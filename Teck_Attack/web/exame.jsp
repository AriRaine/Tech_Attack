<%-- 
    Document   : exame
    Created on : 16 de nov. de 2024, 18:39:49
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exame</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <%if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Informações do Paciente</h1>
        </header>
        <main class="container mt-5 form-wrapper">
            <form class="row g-3">
                <div class="col-12">
                    <label for="inputFullName" class="form-label">Nome completo</label>
                    <input type="text" class="form-control" id="inputFullName" required>
                </div>
                <div class="col-md-6">
                    <label for="inputCPF" class="form-label">CPF</label>
                    <input type="text" class="form-control" id="inputCPF" required>
                </div>
                <div class="col-md-6">
                    <label for="inputBirthday" class="form-label">Data de Nascimento</label>
                    <input type="date" class="form-control" id="inputBirthday" required>
                </div>
                <div class="col-12">
                    <label for="inputAddress" class="form-label">Endereço</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="Av Costa & Silva, 500" required>
                </div>
                <div class="col-md-6">
                    <label for="inputPhone" class="form-label">Telefone</label>
                    <input type="tel" class="form-control" id="inputPhone" placeholder="(XX) XXXXX-XXXX" pattern="\(\d{2}\) \d{5}-\d{4}" required>
                </div>
                <div class="col-md-6">
                    <label for="inputDate" class="form-label">Data do Exame</label>
                    <input type="date" class="form-control" id="inputDate" required>
                </div>
                <div class="col-12">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" required>
                </div>
                <div class="col-md-6">
                    <label for="inputPeso" class="form-label">Peso (kg)</label>
                    <input type="number" class="form-control" id="inputPeso" min="0" step="0.1" placeholder="Ex: 70.5" required>
                </div>
                <div class="col-md-6">
                    <label for="inputAlt" class="form-label">Altura (cm)</label>
                    <input type="number" class="form-control" id="inputAlt" min="0" step="0.1" placeholder="Ex: 175.5" required>
                </div>
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-send"></i> Enviar
                    </button>
                </div>
            </form>
        </main>
        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>
