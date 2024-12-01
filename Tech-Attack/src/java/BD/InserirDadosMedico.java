/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirDadosMedico {

    public static void inserirMedico(String crm, String nome, String sobrenome, String email, String senha) {
        String sql = "INSERT INTO Medico (crm, nome, sobrenome, email, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, crm);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.setString(4, email);
            pstmt.setString(5, senha);

            pstmt.executeUpdate();
            System.out.println("Médico inserido com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir médico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        inserirMedico("CRM1234", "Dr. João", "Santos", "joao.santos@email.com", "senha123");
    }
}
