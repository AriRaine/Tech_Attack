<%-- 
    Document   : upload
    Created on : 16 de nov. de 2024, 18:41:06
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="/target" class="dropzone" id="uploadForm"></form>
        </main>
        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>

<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<script>
    Dropzone.options.uploadForm = {
        paramName: "file",
        maxFilesize: 2,
        acceptedFiles: ".jpeg,.jpg,.png,.pdf",
        dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar."
    };
</script>