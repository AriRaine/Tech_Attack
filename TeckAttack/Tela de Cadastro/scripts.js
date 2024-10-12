document.getElementById('showPasswordCheckbox').addEventListener('change', function() {
    const passwordField = document.getElementById('inputPassword4');
    if (this.checked) {
        passwordField.type = 'text';
    } else {
        passwordField.type = 'password';
    }
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('inputFirstName').value;
    const lastName = document.getElementById('inputLastName').value;
    const email = document.getElementById('inputEmail4').value;
    const password = document.getElementById('inputPassword4').value;

    if (firstName && lastName && email && password) {
        alert('Cadastro realizado com sucesso!');
        // Redirecionar para a página de login ou outra página desejada
        window.location.href = 'login.html';
    } else {
        alert('Por favor, preencha todos os campos.');
    }
});
