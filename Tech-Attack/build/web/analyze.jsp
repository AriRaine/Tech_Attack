<%-- 
    Document   : analyze
    Created on : 30 de nov. de 2024, 15:57:14
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Análise</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <%if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Análise de Imagem de ECG</h1>
        </header>
        <form method="POST" action="analyzeImage" onsubmit="return validateForm()">
            <div style="margin: 50px auto 0; width: 80%; max-width: 600px; text-align: center; background: lightblue; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
                <label for="img_end" class="form-label">Caminho Completo da Imagem</label>
                <!-- Campo de entrada vazio com placeholder indicando o caminho completo -->
                <input type="text" class="form-control" id="img_end" name="imagePath" placeholder="Exemplo: C:/imagens/exemplo.png" required>
                <br>
                <input type="submit" value="Analisar Imagem" class="btn btn-primary"/>
                <div class="form-text" id="basic-addon4" style="font-size:12px; text-align: right;">
                    <a href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
                </div>
            </div>       
        </form>


        <div style="margin: 30px auto; width: 80%; max-width: 600px; text-align: center; padding: 20px;">
            <% if (request.getAttribute("analysisResult") != null) { %>
            <h2>Resultado da Análise:</h2>
            <p><%= request.getAttribute("analysisResult") %></p>
            <% } else if (request.getAttribute("error") != null) { %>
            <p style="color: red;"><%= request.getAttribute("error") %></p>
            <% } %>
        </div>

        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>

        <!-- Script para validação -->
        <script>
            // Validação do formulário
            function validateForm() {
                const inputField = document.getElementById("img_end");
                const imagePath = inputField.value;
                return true; // Permite o envio do formulário
            }
        </script>
    </body>
</html>
