/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ai;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author tatiane
 */
public class img_OpenAI {

    private static final String API_KEY = "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"; // Substitua pela sua chave API real

    public static String analyzeImage(String imageUrl) throws Exception {
        // Criação dos dados da requisição
        JSONObject data = new JSONObject();
        data.put("model", "gpt-4");  // Substitua por um modelo adequado se necessário
        data.put("image", imageUrl);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openai.com/v1/images/analyze"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        // Envio da requisição e recebimento da resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Checando a resposta
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: " + response.statusCode() + " - " + response.body());
        } else {
            // Parseando a resposta JSON e retornando a análise
            JSONObject responseJson = new JSONObject(response.body());
            return responseJson.getJSONArray("choices")
                                .getJSONObject(0)
                                .getString("message");
        }
    }

    // Método que processa a análise da imagem e imprime o resultado
    public static void processImageAnalysis(String imageUrl) {
        try {
            // Chama o método analyzeImage e imprime o resultado
            String analysisResult = analyzeImage(imageUrl);
            System.out.println("Resultado da análise da imagem: " + analysisResult);
        } catch (Exception ex) {
            System.out.println("Erro ao analisar a imagem: " + ex.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        // Coloque o link da imagem aqui
        String imageUrl = "https://drive.google.com/file/d/1UmGWFICX9oLG2UxGe3Lt8Yp0DEuxmIbG/view?usp=drive_link";

        // Chama o método processImageAnalysis para processar e imprimir o resultado
        processImageAnalysis(imageUrl);
    }
}
