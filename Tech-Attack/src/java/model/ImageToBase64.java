/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImageToBase64 {

    // Método para codificar imagem em Base64
    public static String encodeImageToBase64(String imagePath) throws IOException {
        // Carregar o arquivo de imagem
        File imageFile = new File(imagePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath()); // Ler bytes da imagem

        // Codificar em Base64
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static void main(String[] args) {
        // Caminho da imagem
        String imagePath = "C:/Users/tatco/Documents/Projeto-POO/Tech_Attack/Tech-Attack/web/images/eletrocardiograma.png"; // Substitua pelo caminho real da imagem

        try {
            // Converter a imagem para Base64
            String base64Image = encodeImageToBase64(imagePath);

            // Verificar se houve conversão
            if (base64Image != null && !base64Image.isEmpty()) {
                System.out.println("Imagem convertida com sucesso para Base64!");
                System.out.println("Base64: " + base64Image.substring(0, 100) + "..."); // Mostra os 100 primeiros caracteres
            } else {
                System.out.println("Falha na conversão da imagem para Base64.");
            }
        } catch (IOException e) {
            // Capturar e exibir erros, caso ocorram
            System.out.println("Erro ao converter imagem: " + e.getMessage());
        }
    }
}
