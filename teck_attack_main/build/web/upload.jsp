<%-- 
    Document   : upload
    Created on : 12 de nov. de 2024, 14:02:08
    Author     : tatiane
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>

        <%@ include file="WEB-INF/jspf/menu.jspf" %>

        <header class="text-center mt-4">
            <h1>Upload de Arquivos</h1>
        </header>

        <main class="container mt-5 form-wrapper">
            <form action="/target" class="dropzone" id="uploadForm"></form>
        </main>

        <%@ include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<script>
    Dropzone.options.uploadForm = {
        paramName: "file",
        maxFilesize: 2,
        acceptedFiles: ".jpeg,.jpg,.png,.pdf",
        dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar."
    };
</script>