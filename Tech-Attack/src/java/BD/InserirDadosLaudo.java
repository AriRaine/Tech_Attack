/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InserirDadosLaudo {

    public static void inserirLaudo(int idExame, String textoLaudo, String crmMedico) {
        if (!exameExiste(idExame)) {
            System.err.println("Erro: O idExame " + idExame + " não existe na tabela Exame.");
            return;
        }

        if (laudoExiste(idExame)) {
            System.err.println("Erro: O idExame " + idExame + " já está associado a um laudo.");
            return;
        }

        String sql = "INSERT INTO Laudo (idExame, texto_laudo, crmMedico) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, idExame);
            pstmt.setString(2, textoLaudo);
            pstmt.setString(3, crmMedico);

            pstmt.executeUpdate();
            System.out.println("Laudo inserido com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir laudo: " + e.getMessage());
        }
    }

    private static boolean exameExiste(int idExame) {
        String sql = "SELECT 1 FROM Exame WHERE id = ?";
        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, idExame);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.err.println("Erro ao verificar existência do exame: " + e.getMessage());
            return false;
        }
    }

    private static boolean laudoExiste(int idExame) {
        String sql = "SELECT 1 FROM Laudo WHERE idExame = ?";
        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, idExame);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.err.println("Erro ao verificar existência do laudo: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        inserirLaudo(3, "Paciente em boas condições gerais. Sem alterações significativas no ECG.", "CRM1234");
    }
}
