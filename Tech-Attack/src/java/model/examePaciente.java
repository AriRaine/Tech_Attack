/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

public class examePaciente {

    private String nomeCompleto;
    private int cpf;
    private Date dataNascimento;
    private String endereco;
    private int telefone;
    private String emailPaciente;
    private double peso;
    private double altura;
    private String url_img;

    public static ArrayList<examePaciente> list = new ArrayList<>();

    // Construtor principal
    public examePaciente(String nomeCompleto, int cpf, Date dataNascimento, String endereco, int telefone, String emailPaciente, double peso, double altura, String url_img) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emailPaciente = emailPaciente;
        this.peso = peso;
        this.altura = altura;
        this.url_img = url_img;
    }

    // Construtor alternativo sem CPF
    public examePaciente(String nomeCompleto, Date dataNascimento, String endereco, int telefone, String emailPaciente, double peso, double altura, String url_img) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emailPaciente = emailPaciente;
        this.peso = peso;
        this.altura = altura;
        this.url_img = url_img;
    }

    // Getters e Setters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
