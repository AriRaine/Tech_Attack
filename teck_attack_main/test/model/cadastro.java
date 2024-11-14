package model;

// Classe principal Cadastro
public class cadastro {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    public cadastro(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

// Classe CadastroMedico que herda de Cadastro e adiciona o atributo CRM
class cadastroMedico extends cadastro {

    private String crm;

    public cadastroMedico(String nome, String sobrenome, String email, String senha, String crm) {
        super(nome, sobrenome, email, senha);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}

// Classe CadastroFuncionario que herda de Cadastro e adiciona o atributo registro
class cadastroFuncionario extends cadastro {

    private String registro;

    public cadastroFuncionario(String nome, String sobrenome, String email, String senha, String registro) {
        super(nome, sobrenome, email, senha);
        this.registro = registro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
