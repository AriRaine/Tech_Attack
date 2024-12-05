/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ai;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@WebServlet("/analyzeImage")
public class ImageAnalyzerServlet extends HttpServlet {

    private static final String API_KEY = "SUA_CHAVE_OPENAI";
    private static final HttpClient httpClient = createHttpClient();

    private static HttpClient createHttpClient() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            return HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao configurar HttpClient: " + e.getMessage());
        }
    }

    private void resizeImage(String inputPath, String outputPath, int width, int height) throws IOException {
        File inputFile = new File(inputPath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new IOException("Arquivo de imagem inválido.");
        }

        BufferedImage originalImage = ImageIO.read(inputFile);
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());

        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        File outputFile = new File(outputPath);
        ImageIO.write(resizedImage, "png", outputFile);
    }

    private String encodeImage(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static String getCompletion(String base64Image) throws IOException, InterruptedException {
        JSONObject data = new JSONObject();
        data.put("model", "gpt-4o");
        data.put("messages", new JSONArray()
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", "Descreva esta imagem de eletrocardiograma"))
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", "data:image/png;base64," + base64Image))
        );
        data.put("max_tokens", 500);
        data.put("temperature", 0.7);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: " + response.statusCode() + " - " + response.body());
        } else {
            return new JSONObject(response.body())
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String imagePath = req.getParameter("imagePath");
            if (imagePath == null || imagePath.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                req.setAttribute("error", "Parâmetro 'imagePath' é obrigatório.");
                req.getRequestDispatcher("analyze.jsp").forward(req, resp);
                return;
            }

            String resizedImagePath = "resized-image.png";
            resizeImage(imagePath, resizedImagePath, 300, 300);

            String base64Image = encodeImage(resizedImagePath);
            String analysisResult = getCompletion(base64Image);

            req.setAttribute("analysisResult", analysisResult);
            req.getRequestDispatcher("analyze.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Erro ao processar a imagem: " + e.getMessage());
            req.getRequestDispatcher("analyze.jsp").forward(req, resp);
        }
    }
}
