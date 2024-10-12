document.getElementById('showPassword').addEventListener('change', function() {
    const passwordInput = document.getElementById('password');
    if (this.checked) {
        passwordInput.type = 'text'; // Mostra a senha
    } else {
        passwordInput.type = 'password'; // Oculta a senha
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
