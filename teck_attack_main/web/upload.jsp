<%-- 
    Document   : upload
    Created on : 12 de nov. de 2024, 14:02:08
    Author     : tatiane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <header class="text-center mt-4">
            <h1>Upload de Arquivos</h1>

            <main>
                <div  class="container mt-5 form-wrapper" style="text-align: left;">
                    <form class="row g-3">
                        <div class="col-12 ">
                            <label for="inputFullName" class="form-label">Nome completo</label>
                            <input type="text" class="form-control" id="inputFullName">
                        </div>
                        <div class="col-md-6">
                            <label for="inputCPF" class="form-label">CPF</label>
                            <input type="text" class="form-control" id="inputCPF">
                        </div>
                        <div class="col-md-6">
                            <label for="inputBirthday" class="form-label">Data de Nascimento</label>
                            <input type="date" class="form-control" id="inputBirthday">
                        </div>
                        <div class="col-12">
                            <label for="inputAddress" class="form-label">Endereço</label>
                            <input type="text" class="form-control" id="inputAddress" placeholder="Av Costa & Silva, 500">
                        </div>
                        <div class="col-md-6">
                            <label for="inputPhone" class="form-label">Telefone</label>
                            <input type="tel" class="form-control" id="inputPhone" placeholder="(XX) XXXXX-XXXX" pattern="\(\d{2}\) \d{5}-\d{4}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="inputDate" class="form-label">Data do Exame</label>
                            <input type="date" class="form-control" id="inputDate">
                        </div>
                        <div class="col-12">
                            <label for="inputEmail4" class="form-label">Email</label>
                            <input type="email" class="form-control" id="inputEmail4">
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
                </div>
                </form>

                <div class="container mt-5 form-wrapper">
                    <form action="/target" class="dropzone" id="uploadForm"></form>
                </div>
            </main>

            <%@include file="WEB-INF/jspf/footer.jspf" %>

        </header>
    </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN6jIeHz" crossorigin="anonymous"></script>
<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>

<script>
    Dropzone.options.uploadForm = {
        paramName: "file",
        maxFilesize: 2,
        acceptedFiles: ".jpeg,.jpg,.png,.pdf",
        dictDefaultMessage: "Arraste e solte os arquivos aqui para fazer o upload ou clique para selecionar."
    };
</script>
