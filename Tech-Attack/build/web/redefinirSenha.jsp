<%-- 
    Document   : redefinirSenha
    Created on : 24 de nov. de 2024, 00:45:45
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Redefinir Senha</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <div class="card" style="width: 18rem; margin: 50px auto 0; width: 80%; max-width: 600px; padding: 20px; border: 1px solid #ccc; border-radius: 8px;">
            <div class="card-body">
                <h5 class="card-title">Redefinição de Senha</h5>
                <form id="resetPasswordForm">
                    <div class="mb-3">
                        <label for="inputEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="inputEmail" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="inputNewPassword" class="form-label">Nova Senha</label>
                        <input type="password" class="form-control" id="inputNewPassword" name="newPassword" required>
                    </div>
                    <div class="mb-3">
                        <label for="inputConfirmPassword" class="form-label">Confirme a Nova Senha</label>
                        <input type="password" class="form-control" id="inputConfirmPassword" name="confirmPassword" required>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Redefinir Senha">
                    <div class="form-text" id="basic-addon4" style="font-size:12px; text-align: right;">
                        <a href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
    <script>
        document.getElementById("resetPasswordForm").addEventListener("submit", function (event) {
            event.preventDefault();

            const email = document.getElementById("inputEmail").value.trim();
            const newPassword = document.getElementById("inputNewPassword").value.trim();
            const confirmPassword = document.getElementById("inputConfirmPassword").value.trim();

            if (newPassword !== confirmPassword) {
                alert("As senhas não correspondem. Tente novamente.");
                return;
            }

            if (email && newPassword) {
                const data = {email, senha: newPassword};

                fetch("ResetPasswordServlet", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(data),
                })
                        .then(response => response.json())
                        .then(result => {
                            if (result.success) {
                                alert(result.message);
                                document.getElementById("resetPasswordForm").reset();
                                window.location.href = "${pageContext.request.contextPath}/index.jsp";
                            } else {
                                alert(result.error || "Erro ao redefinir senha.");
                            }
                        })
                        .catch(error => {
                            console.error("Erro:", error);
                            alert("Ocorreu um erro ao processar sua solicitação.");
                        });
            } else {
                alert("Por favor, preencha todos os campos.");
            }
        });
    </script>
</html>

