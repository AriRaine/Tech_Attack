package api;

import java.io.*;
import java.nio.file.*;
import java.util.Base64;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;


@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class UploadServlet extends HttpServlet {

    private static final String API_KEY = System.getenv("OPENAI_API_KEY"); // Variável de ambiente

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String destinationPath = request.getParameter("destinationPath");
            if (destinationPath == null || destinationPath.isEmpty()) {
                destinationPath = getServletContext().getRealPath("/uploads"); // Caminho padrão
            }

            Part filePart = request.getPart("file");
            String contentType = filePart.getContentType();
            if (!contentType.startsWith("image/") && !contentType.equals("application/pdf")) {
                throw new IllegalArgumentException("Tipo de arquivo não suportado. Apenas imagens ou PDFs são aceitos.");
            }

            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            File uploadsDir = new File(destinationPath);
            if (!uploadsDir.exists()) {
                uploadsDir.mkdirs();
            }
            File file = new File(uploadsDir, fileName);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            String base64Image = encodeImage(file.getAbsolutePath());
            String prompt = "Descreva as alterações nesta imagem de ECG.";
            String analysisResult = sendRequest(base64Image, prompt);

            response.setContentType("application/json");
            response.getWriter().write(new JSONObject().put("description", analysisResult).toString());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(new JSONObject().put("error", "Erro interno no processamento.").toString());
            e.printStackTrace(); // Log no servidor
        }
    }

    private String encodeImage(String imagePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    private String sendRequest(String base64Image, String prompt) throws IOException, InterruptedException {
        JSONObject data = new JSONObject();
        data.put("model", "gpt-4o-mini");
        data.put("messages", new JSONArray()
                .put(new JSONObject().put("role", "user").put("content", prompt))
                .put(new JSONObject().put("role", "user").put("content", "data:image/png;base64," + base64Image))
        );
        data.put("max_tokens", 500);
        data.put("temperature", 0.7);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na API: " + response.statusCode() + " - " + response.body());
        }

        JSONObject responseJson = new JSONObject(response.body());
        return responseJson.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
    }
}
