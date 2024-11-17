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

@WebServlet(name = "ExamePaciente", urlPatterns = {"/ExamePaciente"})
public class ExamePaciente extends HttpServlet {

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
        // Lê o corpo da requisição e converte para JSONObject
        JSONObject body = getJSONBody(request.getReader());

        // Extrai os campos do JSON
        String nomeCompleto = body.getString("nomeCompleto");
        int cpf = body.optInt("cpf", 0); // CPF é opcional, valor padrão 0
        String dataNascimentoStr = body.getString("dataNascimento");
        String endereco = body.getString("endereco");
        int telefone = body.getInt("telefone");
        String emailPaciente = body.getString("emailPaciente");
        double peso = body.getDouble("peso");
        double altura = body.getDouble("altura");
        String url_img = body.getString("url_img");

        // Converte a data de String para Date
        Date dataNascimento;
        try {
            dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimentoStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use 'yyyy-MM-dd'.");
        }

        // Cria o objeto examePaciente
        examePaciente paciente;
        if (cpf > 0) {
            paciente = new examePaciente(nomeCompleto, cpf, dataNascimento, endereco, telefone, emailPaciente, peso, altura, url_img);
        } else {
            paciente = new examePaciente(nomeCompleto, dataNascimento, endereco, telefone, emailPaciente, peso, altura, url_img);
        }

        // Adiciona à lista estática
        examePaciente.list.add(paciente);

        // Retorna a lista atualizada
        file.put("list", new JSONArray(examePaciente.list));
        response.setStatus(201); // Created

    } catch (Exception ex) {
        response.setStatus(500); // Internal Server Error
        file.put("error", ex.getLocalizedMessage());
    }

    // Retorna a resposta como JSON
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
        } catch (Exception ex) {
            response.setStatus(500);
            file.put("error", ex.getLocalizedMessage());
        }
        response.getWriter().print(file.toString());
    }

    @Override
    public String getServletInfo() {
        return "ExamePaciente for managing user data.";
    }
}
