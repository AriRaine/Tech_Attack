// Serve para simular os emails cadastrados
const emailsCadastrados = ['exemplo@dominio.com','teste@dominio.com'];

// Mostrar ou ocultar a senha
document.getElementById('showPasswordCheckbox').addEventListener('change', function() {
   const passwordField = document.getElementById('inputPassword4');
   passwordField.type = this.checked ? 'text' : 'password'; // Altera o tipo de input
   });

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('inputFirstName').value;
    const lastName = document.getElementById('inputLastName').value;
    const email = document.getElementById('inputEmail4').value;
    const password = document.getElementById('inputPassword4').value;

  // Faz a verificação se o email já foi cadastrado
    if (emailsCadastrados.includes(email)){
        alert('Esse e-mail já está cadastrado. Por favor, utilize outro ou volte a tela de login')
        document.getElementById('backButton').style.display = 'inline-block'; // Serve para exibir o botão de voltar a tela de login
        return;
    }

    if (firstName && lastName && email && password) {
        alert('Cadastro realizado com sucesso!');
        // Redirecionar para a página de login ou outra página desejada
        window.location.href = 'tela%20de%20login/login.html';
    } else {
        alert('Por favor, preencha todos os campos.');
    }
});

    // Ação do botão de voltar a tela de login
    document.getElementById('backButton').addEventListener('click', function(){
        window.location.href = 'tela%20de%20login/login.html';
});
