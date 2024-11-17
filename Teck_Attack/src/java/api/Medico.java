/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import model.Cadastro;

/**
 *
 * @author tatiane
 */
public class Medico extends Cadastro {

    private String crm;

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
