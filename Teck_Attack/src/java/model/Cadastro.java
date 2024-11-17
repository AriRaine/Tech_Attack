package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Cadastro {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    // Lista estática para armazenar todos os cadastros (Medico e Funcionario)
    public static List<Cadastro> list = new ArrayList<>();

    public Cadastro(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
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

    // Método abstrato para obter o identificador único
    public abstract String getIdentificador();
}