<%-- 
    Document   : index-OpenAI
    Created on : 24 de nov. de 2024, 00:44:29
    Author     : tatco
--%>

<%@page import="ai.DevOpenAI"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%
            if (request.getParameter("imagePath") != null) {
                try {
                    String prompt = request.getParameter("prompt");
                    String completion = DevOpenAI.getCompletion(prompt);
                    request.setAttribute("completion", completion);
                } catch (Exception ex) {
                    request.setAttribute("error", ex.getMessage());
                }
            }
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OpenAI</title>
    </head>
    <body>
        <h1>Meu Próprio ChatGPT</h1>
        
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>

        <%
            if (request.getAttribute("error") != null) {%>
        <div>Erro: <%= request.getAttribute("error")%></div>
        <hr/>
        <% } else if (request.getAttribute("completion") != null) {%>
        <h2>Completion</h2>
        <div><%= request.getAttribute("completion")%></div>
        <hr/>
        <% } %>

        Novo Prompt:<br/>
        <form>
            <input type="text" name="prompt" style="width: 80%"/>
            <input type="submit" name="invoke" value="Enviar"/>
        </form>

       <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
       
    </body>
</html>