<%-- 
    Document   : OpenAI
    Created on : 30 de nov. de 2024, 13:23:23
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
        <form method="POST" action="analyzeImage">
            <div style="margin: 50px auto 0; width: 80%; max-width: 600px; text-align: center; background: lightblue; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
                <label for="img_end" class="form-label">Endereço da Imagem do Eletrocardiograma</label>
                <input type="text" class="form-control" id="img_end" name="imagePath" required>
                <br>
                <input type="submit" value="Analisar Imagem" class="btn btn-primary"/>
            </div>       
        </form>

        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>