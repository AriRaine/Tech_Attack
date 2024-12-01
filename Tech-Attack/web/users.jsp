<%-- 
    Document   : users
    Created on : 24 de nov. de 2024, 00:46:57
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>
        <%if (userName != null) { %>
        <div style="margin: 50px auto 0; width: 80%; max-width: 600px; text-align: center; background: lightblue; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
            <h3>Bem vindo(a), </h3>
            <%for (String user : users) {%>
            <h4> <div><%= user %></div></h4>
            <h5>Navegue pela página, através do nosso menu superior.</h5> 
            <% }%>
        </div>
        <% }%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>