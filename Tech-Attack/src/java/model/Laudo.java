/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Laudo {

    private int idLaudo;
    private String textoLaudo;
    private String crmMedico;
    private int idExamePaciente;

    // Campos adicionais para informações do médico
    private String medicoNome;
    private String medicoSobrenome;

    public static List<Laudo> list = new ArrayList<>();

    // Construtor padrão e parametrizado
    public Laudo(String textoLaudo, String crmMedico, int idExamePaciente) {
        this.textoLaudo = textoLaudo;
        this.crmMedico = crmMedico;
        this.idExamePaciente = idExamePaciente;
    }

    // Getters e setters
    public int getIdLaudo() {
        return idLaudo;
    }

    public void setIdLaudo(int idLaudo) {
        this.idLaudo = idLaudo;
    }

    public String getTextoLaudo() {
        return textoLaudo;
    }

    public void setTextoLaudo(String textoLaudo) {
        this.textoLaudo = textoLaudo;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public int getIdExamePaciente() {
        return idExamePaciente;
    }

    public void setIdExamePaciente(int idExamePaciente) {
        this.idExamePaciente = idExamePaciente;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public String getMedicoSobrenome() {
        return medicoSobrenome;
    }

    public void setMedicoSobrenome(String medicoSobrenome) {
        this.medicoSobrenome = medicoSobrenome;
    }
}
