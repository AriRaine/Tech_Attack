package api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.json.JSONArray;
import org.json.JSONObject; // Importando a biblioteca JSON

@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class UploadServlet extends HttpServlet {

    // Diretório onde os arquivos serão salvos
    private static final String UPLOAD_DIR = "C:/meus_uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configuração do diretório de upload
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Processar os arquivos enviados
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = UPLOAD_DIR + File.separator + fileName;
                try (FileOutputStream fos = new FileOutputStream(filePath);
                     InputStream is = part.getInputStream()) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }

        // Responder ao cliente
        response.setContentType("text/html");
        response.getWriter().println("<h1>Upload realizado com sucesso!</h1>");
        response.getWriter().println("<a href='upload.jsp'>Voltar</a>");
    }

    // Extrair o nome do arquivo do cabeçalho da requisição
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}