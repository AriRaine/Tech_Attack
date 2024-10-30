document.addEventListener("DOMContentLoaded", function() {
    const showPasswordCheckbox = document.getElementById("showPasswordCheckbox");
    const newPasswordInput = document.getElementById("inputNewPassword");
    const confirmPasswordInput = document.getElementById("inputConfirmPassword");
    const resetPasswordForm = document.getElementById("resetPasswordForm");

    // Mostrar/ocultar a senha
    showPasswordCheckbox.addEventListener("change", function() {
        if (showPasswordCheckbox.checked) {
            newPasswordInput.type = "text";
            confirmPasswordInput.type = "text";
        } else {
            newPasswordInput.type = "password";
            confirmPasswordInput.type = "password";
        }
    });

    // Validar o formulário ao enviar
    resetPasswordForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        const newPassword = newPasswordInput.value;
        const confirmPassword = confirmPasswordInput.value;

        if (newPassword === confirmPassword) {
            alert("Senha redefinida com sucesso!");
            resetPasswordForm.reset(); // Limpa o formulário após o envio
        } else {
            alert("As senhas não correspondem. Tente novamente.");
        }
    });
});
