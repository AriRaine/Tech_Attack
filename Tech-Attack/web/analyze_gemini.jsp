<%-- 
    Document   : analyze_gemini
    Created on : 30 de nov. de 2024, 17:26:08
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Análise de Imagem de ECG</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <% if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Análise de Imagem de ECG</h1>
        </header>

        <!-- Formulário para análise de imagem -->
        <form method="POST" action="analyzeECG">
            <div style="margin: 50px auto 0; width: 80%; max-width: 600px; text-align: center; background: lightblue; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
                <label for="img_end" class="form-label">Endereço da Imagem do Eletrocardiograma</label>
                <input type="text" class="form-control mb-3" id="img_end" name="imagePath" required>
                <br>
                <input type="submit" value="Analisar Imagem" class="btn btn-primary"/>
                <div class="form-text" id="basic-addon4" style="font-size:12px; text-align: right;">
                    <a href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
                </div>
            </div>       
        </form>

        <!-- Resultado da análise -->
        <div class="analysis-result-container">
            <% if (request.getAttribute("analysisResult") != null) { %>
            <h2 class="analysis-title">Resultado da Análise:</h2>
            <p class="analysis-content"><%= request.getAttribute("analysisResult") %></p>
            <% } else if (request.getAttribute("error") != null) { %>
            <p class="error-message"><%= request.getAttribute("error") %></p>
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
    <style>
        .analysis-result-container {
            margin: 30px auto;
            width: 80%;
            max-width: 600px;
            text-align: justify;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        .analysis-title {
            text-align: center;
            font-size: 1.8em;
            margin-bottom: 15px;
            color: blue;
        }

        .analysis-content {
            font-size: 1.2em;
            line-height: 1.6;
            color: #555;
            white-space: pre-wrap; /* Mantém quebras de linha no texto */
        }

        .error-message {
            font-size: 1.2em;
            color: red;
            font-weight: bold;
        }


    </style>
