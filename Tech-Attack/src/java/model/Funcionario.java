/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatiane
 */
public class Funcionario extends Cadastro {

     private String registro;
     
    public static List<Funcionario> list = new ArrayList<>();

    public Funcionario(String nome, String sobrenome, String email, String senha, String registro) {
        super(nome, sobrenome, email, senha);
        this.registro = registro;
    }

    // Getter e Setter para Registro
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String getIdentificador() {
        return registro;
    }
}

