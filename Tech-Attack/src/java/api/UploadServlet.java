/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // Tamanho limite em memória (2MB)
        maxFileSize = 1024 * 1024 * 10, // Tamanho máximo de arquivo (10MB)
        maxRequestSize = 1024 * 1024 * 50 // Tamanho máximo da requisição (50MB)
)
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "/uploads"; // Caminho absoluto do diretório de uploads

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cria o diretório de uploads, se não existir
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Cria a pasta, incluindo subpastas, se necessário
        }

        try {
            // Processa cada arquivo enviado
            for (Part part : request.getParts()) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // Nome do arquivo
                if (!fileName.isEmpty()) {
                    String filePath = UPLOAD_DIR + File.separator + fileName; // Caminho completo do arquivo
                    part.write(filePath); // Salva o arquivo no local especificado

                    // Envia uma resposta ao cliente com a URL do arquivo
                    response.getWriter().write("{\"url\": \"" + UPLOAD_DIR + "/" + fileName + "\"}");
                }
            }
        } catch (Exception e) {
            // Captura exceções e envia a mensagem de erro
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
            e.printStackTrace();  // Imprime o erro no console para diagnóstico
        }
    }
}
