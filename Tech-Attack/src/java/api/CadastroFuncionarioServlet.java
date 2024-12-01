/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import BD.ConexaoSQLite;
import model.Funcionario;
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
import org.json.JSONException;

@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/CadastroFuncionarioServlet"})
public class CadastroFuncionarioServlet extends HttpServlet {

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
            // Lista de Funcionários
            file.put("list", new JSONArray(Funcionario.list));
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
            // Ler o corpo da requisição
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            JSONObject body = new JSONObject(jsonBody);

            // Atributos
            String nome = body.getString("nome");
            String sobrenome = body.getString("sobrenome");
            String email = body.getString("email");
            String senha = body.getString("senha");
            String registro = body.getString("registro");

            // Criar Funcionario
            Funcionario funcionario = new Funcionario(nome, sobrenome, email, senha, registro);

            String sql = "INSERT INTO Funcionario (registro, nome, sobrenome, email, senha) VALUES (?, ?, ?, ?, ?)";

            try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {

                pstmt.setString(1, registro);
                pstmt.setString(2, nome);
                pstmt.setString(3, sobrenome);
                pstmt.setString(4, email);
                pstmt.setString(5, senha);

                pstmt.executeUpdate();
                System.out.println("Funcionário inserido com sucesso!");

            } catch (Exception e) {
                System.err.println("Erro ao inserir funcionário: " + e.getMessage());
            }

// Adicionar à lista de funcionários
            Funcionario.list.add(funcionario);

            // Retornar lista atualizada
            JSONArray jsonList = new JSONArray();
            for (Funcionario f : Funcionario.list) {  // Corrigido para Funcionario
                JSONObject obj = new JSONObject();
                obj.put("nome", f.getNome());
                obj.put("sobrenome", f.getSobrenome());
                obj.put("email", f.getEmail());
                obj.put("senha", f.getSenha());
                obj.put("registro", f.getIdentificador());
                jsonList.put(obj);
            }

            file.put("list", jsonList);

        } catch (IOException | JSONException ex) {
            response.setStatus(500);
            file.put("error", ex.getMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();

        try {
            // Lê o corpo da requisição e converte para JSONObject
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            JSONObject body = new JSONObject(jsonBody);

            // Identificador do funcionário a ser atualizado
            String identificador = body.getString("registro");

            if (identificador == null || identificador.isEmpty()) {
                response.setStatus(400); // Bad Request
                file.put("error", "Parâmetro 'registro' é obrigatório.");
                response.getWriter().print(file.toString());
                return;
            }

            // Procurar o funcionário na lista
            boolean encontrado = false;
            for (Funcionario f : Funcionario.list) {
                if (f.getIdentificador().equals(identificador)) {
                    // Atualizar os dados do funcionário
                    if (body.has("nome")) {
                        f.setNome(body.getString("nome"));
                    }
                    if (body.has("sobrenome")) {
                        f.setSobrenome(body.getString("sobrenome"));
                    }
                    if (body.has("email")) {
                        f.setEmail(body.getString("email"));
                    }
                    if (body.has("senha")) {
                        f.setSenha(body.getString("senha"));
                    }

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Funcionário não encontrado.");
            } else {
                // Retorna lista atualizada
                JSONArray jsonList = new JSONArray();
                for (Funcionario f : Funcionario.list) {
                    JSONObject obj = new JSONObject();
                    obj.put("nome", f.getNome());
                    obj.put("sobrenome", f.getSobrenome());
                    obj.put("email", f.getEmail());
                    obj.put("senha", f.getSenha());
                    obj.put("registro", f.getIdentificador());
                    jsonList.put(obj);
                }
                file.put("list", jsonList);
                response.setStatus(200); // OK
            }

        } catch (IOException | JSONException ex) {
            response.setStatus(500); // Internal Server Error
            file.put("error", ex.getLocalizedMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject file = new JSONObject();

        try {
            String identificador = request.getParameter("identificador");

            if (identificador == null || identificador.isEmpty()) {
                response.setStatus(400); // Bad Request
                file.put("error", "Parâmetro 'identificador' é obrigatório.");
                response.getWriter().print(file.toString());
                return;
            }

            boolean encontrado = false;

            // Utilizando o iterator para evitar ConcurrentModificationException
            var iterator = Funcionario.list.iterator();
            while (iterator.hasNext()) {
                Funcionario f = iterator.next(); // Corrigido para Funcionario
                if (f.getIdentificador().equals(identificador)) {
                    iterator.remove(); // Remove usando o iterator
                    encontrado = true;
                    break; // Remove e interrompe
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Cadastro não encontrado.");
            } else {
                // Retorna lista atualizada
                JSONArray jsonList = new JSONArray();
                for (Funcionario f : Funcionario.list) { // Corrigido para Funcionario
                    JSONObject obj = new JSONObject();
                    obj.put("nome", f.getNome());
                    obj.put("sobrenome", f.getSobrenome());
                    obj.put("email", f.getEmail());
                    obj.put("senha", f.getSenha());
                    obj.put("registro", f.getIdentificador());
                    jsonList.put(obj);
                }
                file.put("list", jsonList);
                response.setStatus(200); // OK
            }

        } catch (IOException | JSONException ex) {
            response.setStatus(500); // Internal Server Error
            file.put("error", ex.getLocalizedMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "CadastroFuncionarioServlet for managing user data.";
    }
}
