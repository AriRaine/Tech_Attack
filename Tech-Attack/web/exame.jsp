<%-- 
    Document   : exame
    Created on : 24 de nov. de 2024, 00:40:53
    Author     : tatco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exame</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>

        <%if (userName != null) { %>
        <header class="text-center mt-4">
            <h1>Informações do Paciente</h1>
        </header>
        <main class="container mt-5 form-wrapper">
            <form class="row g-3" id="registerForm" method="POST" action="ExamePacienteServlet">
                <div class="col-12">
                    <label for="inputFullName" class="form-label">Nome completo</label>
                    <input type="text" class="form-control" id="inputFullName" name="nomeCompleto" required>
                </div>
                <div class="col-md-6">
                    <label for="inputCPF" class="form-label">CPF</label>
                    <input type="number" class="form-control" id="inputCPF" name="cpf" required>
                </div>
                <div class="col-md-6">
                    <label for="inputBirthday" class="form-label">Data de Nascimento</label>
                    <input type="text" class="form-control" id="inputBirthday" name="dataNascimento" placeholder="yyyy-MM-dd" required>
                </div>
                <div class="col-12">
                    <label for="inputAddress" class="form-label">Endereço</label>
                    <input type="text" class="form-control" id="inputAddress" name="endereco" required>
                </div>
                <div class="col-md-12">
                    <label for="inputPhone" class="form-label">Telefone</label>
                    <input type="text" class="form-control" id="inputPhone" name="telefone" required>
                </div>
                <div class="col-12">
                    <label for="inputEmail4" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" name="emailPaciente" required>
                </div>
                <div class="col-md-6">
                    <label for="inputPeso" class="form-label">Peso (kg)</label>
                    <input type="number" class="form-control" id="inputPeso" min="0" step="0.1" placeholder="Ex: 70.5" name="peso" required>
                </div>
                <div class="col-md-6">
                    <label for="inputAlt" class="form-label">Altura (cm)</label>
                    <input type="number" class="form-control" id="inputAlt" min="0" step="0.1" placeholder="Ex: 175.5" name="altura" required>
                </div>
                <div class="col-12">
                    <label for="inputUrl_img" class="form-label">Endereço da imagem</label>
                    <input type="url" class="form-control" id="inputUrl_img" name="url_img"  required>
                </div>
                <div class="col-12">
                    <label for="inputRegistroFuncionario" class="form-label">Registro Funcionário</label>
                    <input type="text" class="form-control" id="inputRegistroFuncionario" name="url_img" required>
                </div>
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-send"></i> Enviar
                    </button>
                </div>
            </form>

        </main>
        <%}%>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf" %>
    </body>
</html>
<script>
    // Emails cadastrados (simulação)
    const emailsCadastrados = ['exemplo@dominio.com', 'teste@dominio.com'];

    document.getElementById('registerForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Evitar envio padrão do formulário

        // Capturar valores dos campos
        const nomeCompleto = document.getElementById('inputFullName').value;
        const cpf = document.getElementById('inputCPF').value;
        const dataNascimento = document.getElementById('inputBirthday').value;
        const endereco = document.getElementById('inputAddress').value;
        const telefone = document.getElementById('inputPhone').value;
        const emailPaciente = document.getElementById('inputEmail4').value;
        const peso = document.getElementById('inputPeso').value;
        const altura = document.getElementById('inputAlt').value;
        const url_img = document.getElementById('inputUrl_img').value;
        const registroFuncionario = document.getElementById('inputRegistroFuncionario').value;

        // Verificar se o email já está cadastrado
        if (emailsCadastrados.includes(emailPaciente)) {
            alert('Esse e-mail já está cadastrado. Por favor, utilize outro ou volte à tela de login.');
            return;
        }

        // Preparar dados para envio
        const data = {
            nomeCompleto,
            cpf,
            dataNascimento,
            endereco,
            telefone,
            emailPaciente,
            peso,
            altura,
            url_img,
            registroFuncionario
        };

        // Enviar os dados para o servlet
        fetch('ExamePacienteServlet', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
                .then(response => {
                    if (!response.ok) {
                        return response.json().then(err => Promise.reject(err));
                    }
                    return response.json();
                })
                .then(result => {
                    alert('Cadastro realizado com sucesso!');
                    window.location.href = '${pageContext.request.contextPath}/analyze_gemini.jsp'; // Redirecionar após sucesso
                })
                .catch(error => {
                    console.error('Erro:', error);
                    alert('Erro ao cadastrar. Tente novamente.');
                });
    });

</script>