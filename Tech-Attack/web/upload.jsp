<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload de Imagem</title>
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <%@ include file="WEB-INF/jspf/html-head-libs.jspf" %> <!-- Importação de libs adicionais -->
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/navbar.jspf" %> <!-- Navbar -->

        <% if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Upload de Imagem</h1>
        </header>

        <main class="container mt-5 form-wrapper">
            <!-- Formulário de Upload com Dropzone -->
            <form id="uploadForm" action="upload" method="post" enctype="multipart/form-data" class="dropzone">
                <div class="dz-message">
                    Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar.
                </div>
            </form>
        </main>
        <% } %>

        <%@ include file="WEB-INF/jspf/footer.jspf" %> <!-- Footer -->

        <%@ include file="WEB-INF/jspf/html-body-libs.jspf" %> <!-- Scripts adicionais -->

        <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
        <script>
            // Configurações do Dropzone
            Dropzone.options.uploadForm = {
                paramName: "image", // Nome do parâmetro para o servidor
                maxFilesize: 10, // Tamanho máximo permitido para os arquivos (em MB)
                acceptedFiles: ".jpeg,.jpg,.png", // Tipos de arquivos aceitos
                dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar.", // Mensagem padrão
                init: function () {
                    // Callback após o upload bem-sucedido
                    this.on("success", function (file, response) {
                        alert("Upload concluído com sucesso!");
                    });

                    // Callback em caso de erro
                    this.on("error", function (file, errorMessage) {
                        console.error("Erro no upload:", errorMessage);
                        alert("Erro no upload: " + errorMessage);
                    });
                }
            };
        </script>
        <% } %>
    </body>
</html>

<%-- <%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <%@ include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/navbar.jspf" %>

        <% if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Upload de Arquivos</h1>
        </header>

        <main class="container mt-5 form-wrapper">
            <!-- Formulário para upload com Dropzone -->
            <form action="UploadServlet" class="dropzone" id="uploadForm" enctype="multipart/form-data" method="post">
                <input type="hidden" name="destinationPath" value="C:/Users/tatco/Documents/Projeto-POO/Tech_Attack/Tech-Attack/web/images/" />
                <!-- O Dropzone gerará a interface de arraste automaticamente -->
            </form>
        </main>
        <% } %>

        <%@ include file="WEB-INF/jspf/footer.jspf" %>
        <%@ include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>

<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<script>
    // Configurações do Dropzone
    Dropzone.options.uploadForm = {
        paramName: "file", // Nome do parâmetro para o servidor
        maxFilesize: 10, // Tamanho máximo permitido para os arquivos (em MB)
        acceptedFiles: ".jpeg,.jpg,.png,.pdf", // Tipos de arquivos aceitos
        dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar.", // Mensagem padrão exibida
        init: function () {
            // Callback após o upload bem-sucedido
            this.on("success", function (file, response) {
                if (response.description) {
                    alert("Upload concluído com sucesso!\nDescrição: " + response.description);
                } else {
                    alert("Erro no processamento do upload. Detalhes: " + response.error);
                }
            });

            // Callback em caso de erro
            this.on("error", function (file, errorMessage) {
                alert("Erro no upload: " + errorMessage);
            });
        }
    };
</script> --%>
