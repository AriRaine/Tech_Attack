/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import BD.ConexaoSQLite;
import java.io.IOException;
import java.io.BufferedReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;
import org.json.JSONArray;
import model.examePaciente;
import org.json.JSONException;

@WebServlet(name = "ExamePacienteServlet", urlPatterns = {"/ExamePacienteServlet"})
public class ExamePacienteServlet extends HttpServlet {

    private JSONObject getJSONBody(BufferedReader reader) throws IOException {
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return new JSONObject(buffer.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        try {
            file.put("list", new JSONArray(examePaciente.list));
        } catch (JSONException ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        try {
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            JSONObject body = new JSONObject(jsonBody);

            String nomeCompleto = body.getString("nomeCompleto");
            int cpf = body.getInt("cpf");
            String dataNascimento = body.getString("dataNascimento");
            String endereco = body.getString("endereco");
            String telefone = body.getString("telefone");
            String email = body.getString("emailPaciente");
            double peso = body.getDouble("peso");
            double altura = body.getDouble("altura");
            String url_img = body.getString("url_img");
            String registroFuncionario = body.getString("registroFuncionario");

            examePaciente paciente = new examePaciente(nomeCompleto, cpf, dataNascimento, endereco, telefone, email, peso, altura, url_img, registroFuncionario);

            String sql = "INSERT INTO Exame (nomeCompleto, cpf, dataNascimento, endereco, telefone, email, peso, altura, url_img, registroFuncionario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, nomeCompleto);
                pstmt.setInt(2, cpf);
                pstmt.setString(3, dataNascimento);
                pstmt.setString(4, endereco);
                pstmt.setString(5, telefone);
                pstmt.setString(6, email);
                pstmt.setDouble(7, peso);
                pstmt.setDouble(8, altura);
                pstmt.setString(9, url_img);
                pstmt.setString(10, registroFuncionario);

                pstmt.executeUpdate();
                System.out.println("Exame inserido com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao inserir exame: " + e.getMessage());
            }

            examePaciente.list.add(paciente);
            
            file.put("list", new JSONArray(examePaciente.list));
            response.setStatus(201);
        } catch (IOException | JSONException ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        try {
            JSONObject body = getJSONBody(request.getReader());

            String nomeCompleto = body.getString("nomeCompleto");
            boolean encontrado = false;

            for (examePaciente exame : examePaciente.list) {
                if (exame.getNomeCompleto().equals(nomeCompleto)) {
                    if (body.has("cpf")) {
                        exame.setCpf(body.getInt("cpf"));
                    }
                    if (body.has("endereco")) {
                        exame.setEndereco(body.getString("endereco"));
                    }
                    if (body.has("telefone")) {
                        exame.setTelefone(body.getString("telefone"));
                    }
                    if (body.has("emailPaciente")) {
                        exame.setEmailPaciente(body.getString("emailPaciente"));
                    }
                    if (body.has("peso")) {
                        exame.setPeso(body.getDouble("peso"));
                    }
                    if (body.has("altura")) {
                        exame.setAltura(body.getDouble("altura"));
                    }
                    if (body.has("url_img")) {
                        exame.setUrl_img(body.getString("url_img"));
                    }
                    if (body.has("registroFuncionario")) {
                        exame.setUrl_img(body.getString("registroFuncionario"));
                    }
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                response.setStatus(404);
                file.put("error", "Paciente não encontrado.");
            } else {
                file.put("list", new JSONArray(examePaciente.list));
                response.setStatus(200);
            }
        } catch (IOException | JSONException ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();
        try {
            String nomeCompleto = request.getParameter("nomeCompleto");
            if (nomeCompleto == null || nomeCompleto.isEmpty()) {
                response.setStatus(400);
                file.put("error", "O parâmetro 'nomeCompleto' é obrigatório.");
            } else {
                int i = -1;
                for (examePaciente exame : examePaciente.list) {
                    if (exame.getNomeCompleto().equals(nomeCompleto)) {
                        i = examePaciente.list.indexOf(exame);
                        break;
                    }
                }
                if (i > -1) {
                    examePaciente.list.remove(i);
                    file.put("message", "Paciente removido com sucesso.");
                } else {
                    response.setStatus(404);
                    file.put("error", "Paciente não encontrado.");
                }
                file.put("list", new JSONArray(examePaciente.list));
            }
        } catch (JSONException ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "ExamePacienteServlet for managing user data.";
    }
}
