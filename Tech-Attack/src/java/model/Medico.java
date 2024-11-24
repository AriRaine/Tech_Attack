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
public class Medico extends Cadastro {

    private String crm;

    public static List<Medico> list = new ArrayList<>();

    public Medico(String nome, String sobrenome, String email, String senha, String crm) {
        super(nome, sobrenome, email, senha);
        this.crm = crm;
    }

    // Getter e Setter para CRM
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String getIdentificador() {
        return crm;
    }
}
