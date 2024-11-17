<%-- 
    Document   : laudo
    Created on : 16 de nov. de 2024, 18:40:20
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>laudo</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <%if (userName != null) { %>
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
        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>
