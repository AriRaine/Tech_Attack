// Mostrar ou ocultar senha
document.getElementById('showPasswordCheckbox').addEventListener('change', function() {
    const passwordField = document.getElementById('inputPassword');
    if (passwordField){
    passwordField.type = this.checked ? 'text' : 'password'; // Atualiza o tipo do campo de senha
    }
});

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

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
