/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirDadosExame {

    public static void inserirExame(String nomeCompleto, String cpf, String dataNascimento, String endereco, 
                                    String telefone, String email, double peso, double altura, String urlImg, 
                                    String registroFuncionario) {
        String sql = """
            INSERT INTO Exame (nomeCompleto, cpf, dataNascimento, endereco, telefone, email, peso, altura, url_img, registroFuncionario)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conexao = ConexaoSQLite.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, nomeCompleto);
            pstmt.setString(2, cpf);
            pstmt.setString(3, dataNascimento);
            pstmt.setString(4, endereco);
            pstmt.setString(5, telefone);
            pstmt.setString(6, email);
            pstmt.setDouble(7, peso);
            pstmt.setDouble(8, altura);
            pstmt.setString(9, urlImg);
            pstmt.setString(10, registroFuncionario);

            pstmt.executeUpdate();
            System.out.println("Exame inserido com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir exame: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        inserirExame("Carlos Lima", "12345678900", "1990-05-20", "Rua das Flores, 123",
                     "11987654321", "carlos.lima@email.com", 70.5, 1.75,
                     "http://exemplo.com/exame1.jpg", "12345");
    }
}
