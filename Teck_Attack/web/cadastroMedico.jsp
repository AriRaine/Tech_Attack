<%-- 
    Document   : cadastroMedico
    Created on : 16 de nov. de 2024, 18:38:43
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Médico</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>

        <header class="text-center mt-4">
            <h1>Cadastro Médico</h1>
        </header>

        <main class="container mt-5">
            <div class="form-wrapper">
                <form class="row g-3" id="registerForm">
                    <div class="col-12">
                        <label for="inputFirstName" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="inputFirstName" placeholder="Beatriz">
                    </div>
                    <div class="col-12">
                        <label for="inputLastName" class="form-label">Sobrenome</label>
                        <input type="text" class="form-control" id="inputLastName" placeholder="Silva Santos">
                    </div>
                    <div class="col-12">
                        <label for="inputCRM" class="form-label">CRM</label>
                        <input type="text" class="form-control" id="inputCRM" placeholder="1234">
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">E-mail</label>
                        <input type="email" class="form-control" id="inputEmail4">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Senha</label>
                        <input type="password" class="form-control" id="inputPassword4">
                    </div>
                    <div class="col-12 form-check">
                        <input class="form-check-input" type="checkbox" id="showPasswordCheckbox">
                        <label class="form-check-label" for="showPasswordCheckbox">
                            Mostrar senha
                        </label>
                    </div>
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-primary">
                            <i class="bi bi-send"></i> Enviar
                        </button>
                        <button type="button" class="btn btn-secondary" id="backButton" style="display:none;">
                            Tela de login
                        </button>
                    </div>
                    <div class="form-text" id="basic-addon4" style="font-size:12px; text-align: right;">
                        <a href="${pageContext.request.contextPath}/users.jsp">Página Inicial</a>
                    </div>
            </div>
        </div>
    </form>
</div>
</main>
<%@include file="WEB-INF/jspf/footer.jspf" %>
<%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
</body>
<script>
    // Serve para simular os emails cadastrados
    const emailsCadastrados = ['exemplo@dominio.com', 'teste@dominio.com'];

    // Mostrar ou ocultar a senha
    document.getElementById('showPasswordCheckbox').addEventListener('change', function () {
        const passwordField = document.getElementById('inputPassword4');
        passwordField.type = this.checked ? 'text' : 'password'; // Altera o tipo de input
    });

    // Lógica do formulário de cadastro
    document.getElementById('registerForm').addEventListener('submit', function (event) {
        event.preventDefault();

        const firstName = document.getElementById('inputFirstName').value;
        const lastName = document.getElementById('inputLastName').value;
        const email = document.getElementById('inputEmail4').value;
        const password = document.getElementById('inputPassword4').value;
        const crm_medico = document.getElementById('inputCRM').value;

        // Verificação se o e-mail já foi cadastrado
        if (emailsCadastrados.includes(email)) {
            alert('Esse e-mail já está cadastrado. Por favor, utilize outro ou volte à tela de login.');
            document.getElementById('backButton').style.display = 'inline-block'; // Exibe o botão de voltar à tela de login
            return;
        }

        if (firstName && lastName && email && password && crm_medico) {
            alert('Cadastro realizado com sucesso!');
            // Redirecionar para a página de login ou outra página desejada
            window.location.href = 'login.html';
        } else {
            alert('Por favor, preencha todos os campos.');
        }
    });
</script>
</html>
