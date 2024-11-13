<%-- 
    Document   : redefinirSenha
    Created on : 12 de nov. de 2024, 14:05:21
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redefinir Senha</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
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
                </form>
            </div>
        </main>

        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

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