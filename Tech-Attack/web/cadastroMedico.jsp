<%-- 
    Document   : cadastroMedico
    Created on : 24 de nov. de 2024, 00:40:43
    Author     : tatco
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
                <form class="row g-3" id="registerForm" method="POST" action="CadastroMedicoServlet">
                    <div class="col-12">
                        <label for="inputFirstName" class="form-label">Nome</label>
                        <input type="text" class="form-control" id="inputFirstName" name="nome" placeholder=" ">
                    </div>
                    <div class="col-12">
                        <label for="inputLastName" class="form-label">Sobrenome</label>
                        <input type="text" class="form-control" id="inputLastName" name="sobrenome" placeholder=" ">
                    </div>
                    <div class="col-12">
                        <label for="inputCRM" class="form-label">CRM</label>
                        <input type="text" class="form-control" id="inputCRM" name="crm" placeholder=" ">
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">E-mail</label>
                        <input type="email" class="form-control" id="inputEmail4" name="email">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Senha</label>
                        <input type="password" class="form-control" id="inputPassword4" name="senha">
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
                    </div>
                    <div class="form-text" id="basic-addon4" style="font-size:13px; text-align: right; display: flex; justify-content: space-between; align-items: center;">
                        <a href="${pageContext.request.contextPath}/users.jsp">Fazer Login</a>
                        <a href="${pageContext.request.contextPath}/index.jsp">Página Inicial</a>
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
                // Dados para enviar ao servlet
                const data = {
                    nome: firstName,
                    sobrenome: lastName,
                    email: email,
                    senha: password,
                    crm: crm_medico
                };

                // Enviar os dados como JSON usando fetch
                fetch('CadastroMedicoServlet', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                })
                        .then(response => response.json())
                        .then(result => {
                            if (result.error) {
                                alert('Erro: ' + result.error);
                            } else {
                                alert('Cadastro realizado com sucesso!');
                                window.location.href = '${pageContext.request.contextPath}/users.jsp'; // Redirecionar para a tela de login ou outra página
                            }
                        })
                        .catch(error => {
                            console.error('Erro ao enviar dados:', error);
                            alert('Erro ao cadastrar. Tente novamente.');
                        });
            } else {
                alert('Por favor, preencha todos os campos.');
            }
        });

    </script>
</html>
