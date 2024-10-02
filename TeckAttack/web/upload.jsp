<%-- 
    Document   : upload
    Created on : 1 de out. de 2024, 23:01:49
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>laudo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles.css" type="text/css">
    </head>
    <nav
       <%@include file="WEB-INF/jspf/menu.jspf" %>
    </nav>
    <body>

       <h1>Faça o upload aqui <i class="bi bi-arrow-down-circle-fill"></i> </h1>
       <hr>
        <!-- Example of a form that Dropzone can take over -->
        <form action="/target" class="dropzone"></form>
        <footer>
            <p>Software criado por <a href="https://github.com/tatcom23" target="_blank">Tatiana</a>, 
                <a href="https://github.com/AriRaine" target="_blank">Larissa</a> e 
                <a href="https://github.com/BeatrizS97" target="_blank">Beatriz</a>
            </p>
        </footer>
    </body>
</html>