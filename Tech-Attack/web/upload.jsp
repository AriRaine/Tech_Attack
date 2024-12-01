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
        <% } %> <!-- Fechamento da condição -->

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
    </body>
</html>
