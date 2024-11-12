<%-- 
    Document   : index
    Created on : 12 de nov. de 2024, 13:44:08
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
<%@include file="WEB-INF/jspf/menu.jspf" %>
</nav>
    <header class="text-center mt-4">
        <h1>Login</h1>
    </header>
    
    <main class="container mt-5">
        <div class="form-wrapper">
            <form class="row g-3" id="loginForm">
                <div class="col-12">
                    <label for="username" class="form-label">E-mail</label>
                    <input type="email" class="form-control" id="username" placeholder="seuemail@exemplo.com">
                </div>
                <div class="col-12">
                    <label for="inputPassword" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="inputPassword">
                </div>
                <div class="col-12 form-check">
                    <input class="form-check-input" type="checkbox" id="showPasswordCheckbox">
                    <label class="form-check-label" for="showPasswordCheckbox">
                        Mostrar senha
                    </label>
                </div>
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-send"></i> Entrar
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
        // Mostrar ou ocultar senha
        document.getElementById('showPasswordCheckbox').addEventListener('change', function() {
            const passwordField = document.getElementById('inputPassword');
            if (passwordField) {
                passwordField.type = this.checked ? 'text' : 'password'; // Atualiza o tipo do campo de senha
            }
        });

        // Lógica do formulário de login
        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const username = document.getElementById('username').value;
            const password = document.getElementById('inputPassword').value;

            // Simulação de validação
            if (username === '' || password === '') {
                alert('Por favor, preencha todos os campos.');
            } else {
                // Simulação de autenticação
                alert('Login bem-sucedido');
                // Aqui você pode redirecionar para o dashboard, se necessário
                // window.location.href = 'dashboard.html'; // Exemplo de redirecionamento
            }
        });
    </script>
