<%-- 
    Document   : criar.login
    Created on : 2 de out. de 2024, 10:27:54
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
        <title>Criar conta</title>
    </head>
    <body>
        <nav
            <%@include file="WEB-INF/jspf/menu.jspf" %>
        </nav>
        <header>
            <h1 style="margin-bottom: 40px; margin-top: 20px">Criar conta</h1>
        </header>
        <main>
            <form class="row g-3">
                <div class="col-12">
                  <label for="inputFirstName" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="inputFirstName" placeholder="Maria">
                </div>
                <div class="col-12">
                  <label for="inputLastName" class="form-label">Sobrenome</label>
                  <input type="text" class="form-control" id="inputLastName" placeholder="Aparecida da Silva">
                </div>
                <div class="col-md-6">
                  <label for="inputEmail4" class="form-label">E-mail</label>
                  <input type="email" class="form-control" id="inputEmail4">
                </div>
                <div class="col-md-6">
                  <label for="inputPassword4" class="form-label">Senha</label>
                  <input type="password" class="form-control" id="inputPassword4">
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Mostrar senha
                    </label>
                  </div>
                </div>
                <div class="col-12">
                  <button type="submit" class="btn btn-primary">
                      <i class="bi bi-send"></i> Enviar
                  </button>
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
