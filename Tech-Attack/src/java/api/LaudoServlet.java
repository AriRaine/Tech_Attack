/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import model.Laudo;

import java.io.BufferedReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;

@WebServlet(name = "LaudoServlet", urlPatterns = {"/LaudoServlet"})
public class LaudoServlet extends HttpServlet {

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
            file.put("list", new JSONArray(Laudo.list));
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
            // Lê o corpo da requisição e converte para JSONObject
            String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            JSONObject body = new JSONObject(jsonBody);

            // Atributos
            String textoLaudo = body.getString("textoLaudo");
            String crmMedico = body.getString("crmMedico");
            int IdExamePaciente = body.getInt("IdExamePaciente");

            // Criação do objeto Laudo
            Laudo laudo = new Laudo(textoLaudo, crmMedico, IdExamePaciente);

            // Adiciona o novo laudo à lista
            Laudo.list.add(laudo);

            // Retorna a lista atualizada
            JSONArray jsonList = new JSONArray();
            for (Laudo l : Laudo.list) {
                JSONObject obj = new JSONObject();
                obj.put("textoLaudo", l.getTextoLaudo());
                obj.put("crmMedico", l.getCrmMedico());
                obj.put("IdExamePaciente", l.getIdExamePaciente());
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
            JSONObject body = getJSONBody(request.getReader());

            // Atributos do laudo
            int IdExamePaciente = body.getInt("IdExamePaciente");
            String textoLaudo = body.getString("textoLaudo");
            String crmMedico = body.getString("crmMedico");

            // Flag para verificar se o laudo foi encontrado
            boolean encontrado = false;

            // Atualiza o laudo na lista
            for (Laudo l : Laudo.list) {
                if (l.getIdExamePaciente() == IdExamePaciente) {
                    l.setTextoLaudo(textoLaudo);
                    l.setCrmMedico(crmMedico);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Laudo não encontrado.");
            } else {
                // Retorna a lista atualizada
                JSONArray jsonList = new JSONArray();
                for (Laudo l : Laudo.list) {
                    JSONObject obj = new JSONObject();
                    obj.put("textoLaudo", l.getTextoLaudo());
                    obj.put("crmMedico", l.getCrmMedico());
                    obj.put("IdExamePaciente", l.getIdExamePaciente());
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
            String IdExamePaciente = request.getParameter("IdExamePaciente");

            if (IdExamePaciente == null || IdExamePaciente.isEmpty()) {
                response.setStatus(400); // Bad Request
                file.put("error", "Parâmetro 'IdExamePaciente' é obrigatório.");
                response.getWriter().print(file.toString());
                return;
            }

            boolean encontrado = false;

            // Utilizando o iterator para evitar ConcurrentModificationException
            var iterator = Laudo.list.iterator();
            while (iterator.hasNext()) {
                Laudo l = iterator.next();
                if (String.valueOf(l.getIdExamePaciente()).equals(IdExamePaciente)) {
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
                for (Laudo l : Laudo.list) {
                    JSONObject obj = new JSONObject();
                    obj.put("textoLaudo", l.getTextoLaudo());
                    obj.put("crmMedico", l.getCrmMedico());
                    obj.put("IdExamePaciente", l.getIdExamePaciente());
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
        return "LaudoServlet for managing user data.";
    }
}
