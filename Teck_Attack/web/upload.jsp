<%-- 
    Document   : upload
    Created on : 16 de nov. de 2024, 18:41:06
    Author     : tatiane
--%>

%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <%if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Upload de Arquivos</h1>
        </header>

        <main class="container mt-5 form-wrapper">
            <!-- A classe Dropzone transforma esse formulário em uma área de upload com drag-and-drop -->
            <form action="UploadServlet" class="dropzone" id="uploadForm" enctype="multipart/form-data">
                <!-- Aqui o Dropzone vai criar a área de arraste para arquivos -->
            </form>
        </main>
        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>

<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<script>
    // Configurações do Dropzone
    Dropzone.options.uploadForm = {
        paramName: "file", // Nome do parâmetro que será enviado ao servidor
        maxFilesize: 10, // Tamanho máximo do arquivo (em MB)
        acceptedFiles: ".jpeg,.jpg,.png,.pdf", // Tipos de arquivos aceitos
        dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar.", // Mensagem padrão
        init: function () {
            // Callback após o upload bem-sucedido
            this.on("success", function (file, response) {
                // Aqui você pode manipular a resposta do servidor (URL do arquivo, por exemplo)
                if (response.url) {
                    alert("Arquivo enviado com sucesso! URL: " + response.url);
                } else {
                    alert("Erro no upload: " + response.error);
                }
            });

            // Callback de erro
            this.on("error", function (file, errorMessage) {
                alert("Erro ao fazer o upload: " + errorMessage);
            });
        }
    };
</script>
