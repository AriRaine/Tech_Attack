package api;

import java.io.IOException;
import java.io.BufferedReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import model.Cadastro;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroServlet extends HttpServlet {

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
            file.put("list", new JSONArray(Cadastro.list));
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
            JSONObject body = getJSONBody(request.getReader());
            String nome = body.getString("nome");
            String sobrenome = body.getString("sobrenome");
            String email = body.getString("email");
            String senha = body.getString("senha");

            if (nome != null && sobrenome != null && email != null && senha != null) {
                Cadastro c = new Cadastro(nome, sobrenome, email, senha);
                Cadastro.list.add(c);
            }
            file.put("list", new JSONArray(Cadastro.list));
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
            String email = request.getParameter("email");
            int i = -1;
            for (Cadastro c : Cadastro.list) {
                if (c.getEmail().equals(email)) {
                    i = Cadastro.list.indexOf(c);
                    break;
                }
            }
            if (i > -1) {
                Cadastro.list.remove(i);
            }
            file.put("list", new JSONArray(Cadastro.list));
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "CadastroServlet for managing user data.";
    }
}
