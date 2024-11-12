<%-- 
    Document   : laudo
    Created on : 12 de nov. de 2024, 14:04:41
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>laudo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="styles.css">
        
    </head>
    <body>
<%@include file="WEB-INF/jspf/menu.jspf" %>
    <header class="text-center mt-4">
        <h1>Laudo</h1>
    </header>
        
        <main class="container mt-5">
        <div class="card">
            <img src="..." class="card-img-top" alt="Imagem do laudo">
            <div class="card-body">
                <h5 class="card-title">Título do Laudo</h5>
                <p class="card-text">Texto de exemplo para descrever o conteúdo do laudo.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Eletrocardiograma</li>
                <li class="list-group-item">Paciente: [Nome do Paciente]</li>
                <li class="list-group-item">Data do exame: [Data]</li>
            </ul>
            <div class="card-body">
                <button onclick="window.open('laudo.pdf', '_blank');" class="btn btn-primary">Abrir Laudo PDF</button>
                <a href="laudo.pdf" download class="btn btn-primary">Baixar Laudo PDF</a>
            </div>
        </div>
    </main>
    
<%@include file="WEB-INF/jspf/footer.jspf" %>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
