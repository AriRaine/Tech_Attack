<%-- 
    Document   : redefinirSenha
    Created on : 24 de nov. de 2024, 00:45:45
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redefinir Senha</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    <header class="text-center mt-4">
        <h1>Redefinir Senha</h1>
    </header>
    <main class="container mt-5">
        <div class="form-wrapper">
            <form class="row g-3" id="resetPasswordForm">
                <div class="col-12">
                    <label for="inputEmail" class="form-label">E-mail</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="seuemail@exemplo.com" required>
                </div>
                <div class="col-12">
                    <label for="inputNewPassword" class="form-label">Nova Senha</label>
                    <input type="password" class="form-control" id="inputNewPassword" required>
                </div>
                <div class="col-12">
                    <label for="inputConfirmPassword" class="form-label">Confirmar Nova Senha</label>
                    <input type="password" class="form-control" id="inputConfirmPassword" required>
                </div>
                <div class="col-12 form-check">
                    <input class="form-check-input" type="checkbox" id="showPasswordCheckbox">
                    <label class="form-check-label" for="showPasswordCheckbox">
                        Mostrar senha
                    </label>
                </div>
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-send"></i> Redefinir Senha
                    </button>
                </div>
                <div class="form-text" id="basic-addon4" style="font-size:12px; text-align: right;">
                    <a href="${pageContext.request.contextPath}/users.jsp">Página Inicial</a>
                </div>
            </form>
        </div>
    </main>
    <%@include file="WEB-INF/jspf/footer.jspf" %>
    <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
</body>
</html>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const showPasswordCheckbox = document.getElementById("showPasswordCheckbox");
        const newPasswordInput = document.getElementById("inputNewPassword");
        const confirmPasswordInput = document.getElementById("inputConfirmPassword");
        const resetPasswordForm = document.getElementById("resetPasswordForm");

        // Mostrar/ocultar a senha
        showPasswordCheckbox.addEventListener("change", function () {
            if (showPasswordCheckbox.checked) {
                newPasswordInput.type = "text";
                confirmPasswordInput.type = "text";
            } else {
                newPasswordInput.type = "password";
                confirmPasswordInput.type = "password";
            }
        });

        // Validar o formulário ao enviar
        resetPasswordForm.addEventListener("submit", function (event) {
            event.preventDefault(); // Impede o envio padrão do formulário

            const newPassword = newPasswordInput.value;
            const confirmPassword = confirmPasswordInput.value;

            if (newPassword === confirmPassword) {
                alert("Senha redefinida com sucesso!");
                resetPasswordForm.reset(); // Limpa o formulário após o envio
                window.location.href = "../Tela%20de%20Login/login.html"; // Redireciona para a tela de login
            } else {
                alert("As senhas não correspondem. Tente novamente.");
            }
        });
    });
</script>
