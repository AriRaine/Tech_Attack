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
        // Ler o corpo da requisição
        String jsonBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        JSONObject body = new JSONObject(jsonBody);

        // Obter o tipo do cadastro (médico ou funcionário)
        String tipo = body.getString("tipo");

        // Atributos comuns
        String nome = body.getString("nome");
        String sobrenome = body.getString("sobrenome");
        String email = body.getString("email");
        String senha = body.getString("senha");

        Cadastro cadastro;

        // Criar o objeto baseado no tipo
        if ("medico".equalsIgnoreCase(tipo)) {
            if (!body.has("crm")) {
                throw new IllegalArgumentException("CRM é obrigatório para cadastro de médico.");
            }
            String crm = body.getString("crm");
            cadastro = new Medico(nome, sobrenome, email, senha, crm);
        } else if ("funcionario".equalsIgnoreCase(tipo)) {
            if (!body.has("registro")) {
                throw new IllegalArgumentException("Registro é obrigatório para cadastro de funcionário.");
            }
            String registro = body.getString("registro");
            cadastro = new Funcionario(nome, sobrenome, email, senha, registro);
        } else {
            throw new IllegalArgumentException("Tipo de cadastro inválido. Use 'medico' ou 'funcionario'.");
        }

        // Adicionar à lista
        Cadastro.list.add(cadastro);

        // Retornar lista atualizada
        JSONArray jsonList = new JSONArray();
        for (Cadastro c : Cadastro.list) {
            JSONObject obj = new JSONObject();
            obj.put("nome", c.getNome());
            obj.put("sobrenome", c.getSobrenome());
            obj.put("email", c.getEmail());
            obj.put("senha", c.getSenha());
            obj.put("tipo", c instanceof Medico ? "medico" : "funcionario");
            obj.put("identificador", c.getIdentificador());
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

            for (Cadastro c : Cadastro.list) {
                if (c.getIdentificador().equals(identificador)) {
                    Cadastro.list.remove(c);
                    encontrado = true;
                    break; // Remove e interrompe
                }
            }

            if (!encontrado) {
                response.setStatus(404); // Not Found
                file.put("error", "Cadastro não encontrado.");
            } else {
                file.put("list", new JSONArray(Cadastro.list));
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
        return "CadastroServlet for managing user data.";
    }
}
