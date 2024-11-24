<%-- 
    Document   : index
    Created on : 24 de nov. de 2024, 00:44:58
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/_navbar.jspf" %> <!-- criar um menu alternativo para a home (com Home, login e cadastro) -->
        <div class="m-3">
            <h1>Conteudo da pagina</h1>
        </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>
