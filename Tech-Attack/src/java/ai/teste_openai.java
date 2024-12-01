/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ai;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;

public class teste_openai {

    // Chave da API do OpenAI
    private static final String API_KEY = "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"; 

    // Função para redimensionar a imagem
    public static void resizeImage(String inputPath, String outputPath, int width, int height) throws IOException {
        File inputFile = new File(inputPath);
        BufferedImage originalImage = ImageIO.read(inputFile);

        // Criando uma nova imagem redimensionada
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        // Salvando a imagem redimensionada
        File outputFile = new File(outputPath);
        ImageIO.write(resizedImage, "png", outputFile);
    }

    // Função para codificar a imagem em Base64
    public static String encodeImage(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    // Função para enviar a requisição à API do OpenAI
    public static String sendRequest(String base64Image, String prompt) throws IOException, InterruptedException {
        JSONObject data = new JSONObject();
        data.put("model", "gpt-4o");
        data.put("messages", new JSONArray()
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", prompt)
                )
                .put(new JSONObject()
                        .put("role", "user")
                        .put("content", "data:image/png;base64," + base64Image)
                )
        );
        data.put("max_tokens", 500);
        data.put("temperature", 0.7);

        // Envio da requisição para a API OpenAI
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: " + response.statusCode() + " - " + response.body());
        }

        // Processar a resposta da API
        JSONObject responseJson = new JSONObject(response.body());
        return responseJson.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
    }

    public static void main(String[] args) {
        try {
            String prompt = "Descreva esta imagem de ECG.";

            // Caminho da imagem original
            String inputImagePath = "C:/Users/tatco/Documents/Projeto-POO/Tech_Attack/Tech-Attack/web/images/Eletrocardiograma-Flutter-atrial-BAV-BRD-Masculino-68-anos.bmp";
            // Caminho da imagem redimensionada
            String resizedImagePath = "C:/Users/tatco/Documents/Projeto-POO/Tech_Attack/Tech-Attack/web/images/Flutter-atrial_resized.png";

            // Redimensionar a imagem (exemplo: 300x300 pixels)
            resizeImage(inputImagePath, resizedImagePath, 300, 300);

            // Codificar a imagem redimensionada para Base64
            String base64Image = encodeImage(resizedImagePath);

            // Enviar a requisição para a API OpenAI com a imagem em Base64
            String response = sendRequest(base64Image, prompt);

            // Exibir a resposta da API
            System.out.println("Resposta da API OpenAI: " + response);
        } catch (Exception ex) {
            System.err.println("ERRO: " + ex.getMessage());
        }
    }
}
