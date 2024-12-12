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
import java.io.BufferedReader;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 31605759856
 */
@WebServlet(name = "RedefinirSenha", urlPatterns = {"/RedefinirSenha"})
public class RedefinirSenha extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");
    JSONObject jsonResponse = new JSONObject();

    try {
        // Obter o corpo da requisição em formato JSON
        JSONObject body = getJSONBody(request);

        String email = body.optString("email");
        String senha = body.optString("novaSenha");

        // Validar os campos obrigatórios
        if (email.isEmpty() || senha.isEmpty()) {
            response.setStatus(400); // Bad Request
            jsonResponse.put("error", "Os campos 'email' e 'novaSenha' são obrigatórios.");
            response.getWriter().print(jsonResponse.toString());
            return;
        }

        // Conectar ao banco de dados e redefinir a senha
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Program Files/SQLiteStudio/tech-attack")) {
            // SQL para atualizar a senha do usuário nas tabelas Funcionario e Medico
            String sqlFuncionario = "UPDATE Funcionario SET senha = ? WHERE email = ?";
            String sqlMedico = "UPDATE Medico SET senha = ? WHERE email = ?";

            try (PreparedStatement statementFuncionario = connection.prepareStatement(sqlFuncionario);
                 PreparedStatement statementMedico = connection.prepareStatement(sqlMedico)) {

                // Configurar os parâmetros para a atualização da senha
                statementFuncionario.setString(1, senha);
                statementFuncionario.setString(2, email);

                statementMedico.setString(1, senha);
                statementMedico.setString(2, email);

                // Executar a atualização nas duas tabelas
                int rowsUpdatedFuncionario = statementFuncionario.executeUpdate();
                int rowsUpdatedMedico = statementMedico.executeUpdate();

                if (rowsUpdatedFuncionario > 0 || rowsUpdatedMedico > 0) {
                    // Senha atualizada com sucesso
                    jsonResponse.put("success", true);
                    jsonResponse.put("message", "Senha redefinida com sucesso.");
                    response.setStatus(200);
                } else {
                    // E-mail não encontrado
                    response.setStatus(404); // Not Found
                    jsonResponse.put("error", "Email não encontrado.");
                }
            }
        } catch (Exception e) {
            response.setStatus(500); // Internal Server Error
            jsonResponse.put("error", "Erro ao redefinir a senha: " + e.getMessage());
        }
    } catch (Exception e) {
        response.setStatus(500); // Internal Server Error
        jsonResponse.put("error", "Erro ao processar a solicitação: " + e.getMessage());
    }

    response.getWriter().print(jsonResponse.toString());
}

@Override
public String getServletInfo() {
    return "Servlet para redefinir senha do usuário.";
}

// Método auxiliar para obter o corpo da requisição como JSON
private JSONObject getJSONBody(HttpServletRequest request) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    try (BufferedReader reader = request.getReader()) {
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
    }
    return new JSONObject(sb.toString());
}
}
