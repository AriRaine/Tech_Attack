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
public class OpenAI {

    private static final String API_KEY = "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";

    public static String getCompletion(String prompt) throws Exception {
        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");
        data.put("messages", new JSONArray()
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", prompt)
                )
        );
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openai.com/v1/chat/completions"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

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

    public static void main(String[] args) {
        try {
            System.out.println(OpenAI.getCompletion("existe alguma forma que eu possa te enviar uma imagem para ser analisada?"));
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getLocalizedMessage());
        }
    }
}
