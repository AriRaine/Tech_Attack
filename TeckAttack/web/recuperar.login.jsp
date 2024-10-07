<%-- 
    Document   : recuperar.login
    Created on : 2 de out. de 2024, 10:17:06
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
        <title>Recuperar Senha</title>
    </head>
    <body>
        <nav
            <%@include file="WEB-INF/jspf/menu.jspf" %>
    </nav>
    <header>
        <h1>Recuperar Senha</h1>
    </header>
    <main>
        <form class="login">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Favor informar seu e-mail</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="wrapper">
                <a href="index.jsp" style="padding-top: 15px; font-size: 12px">
                    <i class="bi bi-arrow-left-short"></i>Voltar</a>
                <button type="submit" class="btn btn-primary"><i class="bi bi-send"></i> Confirmar</button>
            </div>
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
