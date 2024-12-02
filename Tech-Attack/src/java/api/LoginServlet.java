/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private JSONObject getJSONBody(HttpServletRequest request) throws IOException, JSONException {
        StringBuilder buffer = new StringBuilder();
        String line;
        try (var reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }
        return new JSONObject(buffer.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsonResponse = new JSONObject();

        try {
            JSONObject body = getJSONBody(request);

            String email = body.optString("email");
            String senha = body.optString("senha");

            if (email.isEmpty() || senha.isEmpty()) {
                response.setStatus(400); // Bad Request
                jsonResponse.put("error", "Os campos 'email' e 'senha' são obrigatórios.");
                response.getWriter().print(jsonResponse.toString());
                return;
            }

            // Verificar se é o admin
            if (email.equals("admin@email.com") && senha.equals("admin123")) {
                HttpSession session = request.getSession();
                session.setAttribute("name", "Admin");

                jsonResponse.put("success", true);
                jsonResponse.put("message", "Login bem-sucedido.");
                jsonResponse.put("userName", "Admin");
                response.setStatus(200);
                response.getWriter().print(jsonResponse.toString());
                return;
            }

            // Conectar ao banco de dados e verificar login
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/tatco/Documents/BD-projeto/tech-attack")) {
                String sql = "SELECT nome FROM Funcionario WHERE email = ? AND senha = ? UNION SELECT nome FROM Medico WHERE email = ? AND senha = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, email);
                    statement.setString(2, senha);
                    statement.setString(3, email);
                    statement.setString(4, senha);

                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            String userName = rs.getString("nome");

                            // Iniciar sessão
                            HttpSession session = request.getSession();
                            session.setAttribute("name", userName);

                            // Responder com sucesso
                            jsonResponse.put("success", true);
                            jsonResponse.put("message", "Login bem-sucedido.");
                            jsonResponse.put("userName", userName);
                            response.setStatus(200);
                        } else {
                            // Login falhou
                            response.setStatus(401); // Unauthorized
                            jsonResponse.put("error", "Email ou senha inválidos.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            response.setStatus(500); // Internal Server Error
            jsonResponse.put("error", "Erro ao processar o login: " + e.getMessage());
        }

        response.getWriter().print(jsonResponse.toString());
    }

    @Override
    public String getServletInfo() {
        return "LoginServlet for handling user authentication.";
    }
}
