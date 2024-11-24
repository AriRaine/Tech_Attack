/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import java.io.IOException;
import java.io.BufferedReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONArray;
import model.examePaciente;
import org.json.JSONException;

@WebServlet(name = "ExamePacienteServlet", urlPatterns = {"/ExamePacienteServlet"})
public class ExamePacienteServlet extends HttpServlet {

    private JSONObject getJSONBody(BufferedReader reader) throws Exception {
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
            JSONObject body = getJSONBody(request.getReader());

            String nomeCompleto = body.getString("nomeCompleto");
            int cpf = body.optInt("cpf", 0);
            String dataNascimentoStr = body.getString("dataNascimento");
            String endereco = body.getString("endereco");
            int telefone = body.getInt("telefone");
            String emailPaciente = body.getString("emailPaciente");
            double peso = body.getDouble("peso");
            double altura = body.getDouble("altura");
            String url_img = body.getString("url_img");

            Date dataNascimento;
            try {
                dataNascimento = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimentoStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Formato de data inválido. Use 'yyyy-MM-dd'.");
            }

            examePaciente paciente;
            if (cpf > 0) {
                paciente = new examePaciente(nomeCompleto, cpf, dataNascimento, endereco, telefone, emailPaciente, peso, altura, url_img);
            } else {
                paciente = new examePaciente(nomeCompleto, dataNascimento, endereco, telefone, emailPaciente, peso, altura, url_img);
            }

            examePaciente.list.add(paciente);
            file.put("list", new JSONArray(examePaciente.list));
            response.setStatus(201);

        } catch (Exception ex) {
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
                    if (body.has("dataNascimento")) {
                        try {
                            Date dataNascimento = new SimpleDateFormat("dd-MM-yyyy").parse(body.getString("dataNascimento"));
                            exame.setDataNascimento(dataNascimento);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Formato de data inválido. Use 'yyyy-MM-dd'.");
                        }
                    }
                    if (body.has("endereco")) {
                        exame.setEndereco(body.getString("endereco"));
                    }
                    if (body.has("telefone")) {
                        exame.setTelefone(body.getInt("telefone"));
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
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Paciente não encontrado.");
            } else {
                file.put("list", new JSONArray(examePaciente.list));
                response.setStatus(200); // OK
            }

        } catch (Exception ex) {
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
            int i = -1;
            for (examePaciente exame : examePaciente.list) {
                if (exame.getNomeCompleto().equals(nomeCompleto)) {
                    i = examePaciente.list.indexOf(exame);
                    break;
                }
            }
            if (i > -1) {
                examePaciente.list.remove(i);
            }
            file.put("list", new JSONArray(examePaciente.list));
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
