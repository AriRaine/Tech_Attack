<%-- 
    Document   : laudo
    Created on : 1 de out. de 2024, 22:00:19
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Laudo</title>
    </head>
    <body>
        <nav
            <%@include file="WEB-INF/jspf/menu.jspf" %>
         </nav>
        <h1>Laudo</h1>
        <div class="card" style="width: 38rem" >
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Eletrocardiograma</li>
              <li class="list-group-item">Paciente:</li>
              <li class="list-group-item">Data do exame:</li>
            </ul>
            <div class="card-body">
              <a href="#" class="card-link">Laudo PDF</a>
              <a href="#" class="card-link">Baixe aqui</a>
            </div>
         </div>
    </body>
</html>
