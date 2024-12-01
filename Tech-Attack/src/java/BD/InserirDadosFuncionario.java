/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InserirDadosFuncionario {

    // Método para inserir um funcionário
    public static void inserirFuncionario(String registro, String nome, String sobrenome, String email, String senha) {
        String sql = "INSERT INTO Funcionario (registro, nome, sobrenome, email, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, registro);
            pstmt.setString(2, nome);
            pstmt.setString(3, sobrenome);
            pstmt.setString(4, email);
            pstmt.setString(5, senha);

            pstmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    // Método para listar todos os funcionários
    public static void listarFuncionarios() {
        String sql = "SELECT registro, nome, sobrenome, email FROM Funcionario";

        try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Registro: " + rs.getString("registro"));
                System.out.println("Nome: " + rs.getString("nome") + " " + rs.getString("sobrenome"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    // Método para atualizar um funcionário
    public static void atualizarFuncionario(String registro, String nome, String sobrenome, String email, String senha) {
        String sql = "UPDATE Funcionario SET nome = ?, sobrenome = ?, email = ?, senha = ? WHERE registro = ?";

        try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, sobrenome);
            pstmt.setString(3, email);
            pstmt.setString(4, senha);
            pstmt.setString(5, registro);

            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Funcionário com o registro " + registro + " não encontrado.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    // Método para excluir um funcionário
    public static void excluirFuncionario(String registro) {
        String sql = "DELETE FROM Funcionario WHERE registro = ?";

        try (Connection conexao = ConexaoSQLite.conectar(); PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, registro);

            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário excluído com sucesso!");
            } else {
                System.out.println("Funcionário com o registro " + registro + " não encontrado.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }

    // Método para testar a conexão com o banco
    public static void testarConexao() {
        try (Connection conexao = ConexaoSQLite.conectar()) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados bem-sucedida!");
            } else {
                System.err.println("Erro ao conectar ao banco de dados.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testarConexao(); // Testa a conexão com o banco de dados

        // Insere um funcionário de exemplo
        inserirFuncionario("12347", "Carlos", "Oliveira", "carlosneiva@email.com", "senha456");

        // Lista todos os funcionários
        listarFuncionarios();

        // Atualiza um funcionário
        atualizarFuncionario("12347", "Carlos", "Silva", "carlosHenriquenovo@email.com", "novaSenha456");

        // Lista novamente para verificar a atualização
        listarFuncionarios();

        // Exclui o funcionário
        excluirFuncionario("12347");

        // Lista novamente para verificar a exclusão
        listarFuncionarios();
    }
}
