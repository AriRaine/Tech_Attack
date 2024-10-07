<%-- 
    Document   : index
    Created on : 1 de out. de 2024, 21:55:16
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles.css" type="text/css">
        <title>Home</title>
    </head>
    <body>
        <nav
            <%@include file="WEB-INF/jspf/menu.jspf" %>
    </nav>
    <header>
        <h1>Fazer Login</h1>
        <p>Ir para o TeckAttack</p>
    </header>
    <main>
        <form class="login">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Login</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text" style="font-size: 12px;">Nunca compartilhe seu login e senha!</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Senha</label>
                <input type="password" class="form-control" id="exampleInputPassword1">
                <div id="emailHelp" class="form-text wrapper"><a href="recuperar.login.jsp" target="_blank">Recuperar Senha</a>
                    <a href="criar.conta.jsp" target="_blank">Criar conta</a>
                </div>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1"><i class="bi bi-eye-fill"></i></label>
            </div>
            <button type="submit" class="btn btn-primary"><i class="bi bi-send"></i> Enviar</button>
        </form>
    </main>
    <footer>
        <p>Software criado por <a href="https://github.com/tatcom23" target="_blank">Tatiana</a>, 
            <a href="https://github.com/AriRaine" target="_blank">Larissa</a> e 
            <a href="https://github.com/BeatrizS97" target="_blank">Beatriz</a>
        </p>
    </footer>
</body>
</html>
