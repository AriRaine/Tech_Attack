/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import model.Medico;
import java.io.IOException;
import java.io.BufferedReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;

@WebServlet(name = "CadastroMedicoServlet", urlPatterns = {"/CadastroMedicoServlet"})
public class CadastroMedicoServlet extends HttpServlet {

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
            file.put("list", new JSONArray(Medico.list));
        } catch (Exception ex) {
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
            String crm = body.getString("crm");

            Medico medico;

            medico = new Medico(nome, sobrenome, email, senha, crm);

            Medico.list.add(medico);

            // Retornar lista atualizada
            JSONArray jsonList = new JSONArray();
            for (Medico m : Medico.list) {
                JSONObject obj = new JSONObject();
                obj.put("nome", m.getNome());
                obj.put("sobrenome", m.getSobrenome());
                obj.put("email", m.getEmail());
                obj.put("senha", m.getSenha());
                obj.put("crm", m.getIdentificador());
                jsonList.put(obj);
            }

            file.put("list", jsonList);

        } catch (Exception ex) {
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
            // Ler o corpo da requisição
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            JSONObject body = new JSONObject(jsonBody);

            // Identificador do médico a ser atualizado
            String crm = body.getString("crm");

            if (crm == null || crm.isEmpty()) {
                response.setStatus(400); // Bad Request
                file.put("error", "Parâmetro 'crm' é obrigatório.");
                response.getWriter().print(file.toString());
                return;
            }

            // Procurar o médico na lista
            boolean encontrado = false;
            for (Medico m : Medico.list) {
                if (m.getIdentificador().equals(crm)) {
                    // Atualizar os dados do médico
                    if (body.has("nome")) {
                        m.setNome(body.getString("nome"));
                    }
                    if (body.has("sobrenome")) {
                        m.setSobrenome(body.getString("sobrenome"));
                    }
                    if (body.has("email")) {
                        m.setEmail(body.getString("email"));
                    }
                    if (body.has("senha")) {
                        m.setSenha(body.getString("senha"));
                    }

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Médico não encontrado.");
            } else {
                // Retornar lista atualizada
                JSONArray jsonList = new JSONArray();
                for (Medico m : Medico.list) {
                    JSONObject obj = new JSONObject();
                    obj.put("nome", m.getNome());
                    obj.put("sobrenome", m.getSobrenome());
                    obj.put("email", m.getEmail());
                    obj.put("senha", m.getSenha());
                    obj.put("crm", m.getIdentificador());
                    jsonList.put(obj);
                }
                file.put("list", jsonList);
                response.setStatus(200); // OK
            }

        } catch (Exception ex) {
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
            var iterator = Medico.list.iterator();
            while (iterator.hasNext()) {
                Medico m = iterator.next();
                if (m.getIdentificador().equals(identificador)) {
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
                for (Medico m : Medico.list) {
                    JSONObject obj = new JSONObject();
                    obj.put("nome", m.getNome());
                    obj.put("sobrenome", m.getSobrenome());
                    obj.put("email", m.getEmail());
                    obj.put("senha", m.getSenha());
                    obj.put("crm", m.getIdentificador());
                    jsonList.put(obj);
                }
                file.put("list", jsonList);
                response.setStatus(200); // OK
            }

        } catch (Exception ex) {
            response.setStatus(500); // Internal Server Error
            file.put("error", ex.getLocalizedMessage());
        }

        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "CadastroMedicoServlet for managing user data.";
    }
}
