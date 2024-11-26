/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.Statement;

public class InicializarBanco {

    public static void criarTabelas() {
        String tabelaFuncionario = """
            CREATE TABLE IF NOT EXISTS Funcionario (
                registro TEXT PRIMARY KEY,
                nome TEXT NOT NULL,
                sobrenome TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                senha TEXT NOT NULL
            );
        """;

        String tabelaMedico = """
            CREATE TABLE IF NOT EXISTS Medico (
                crm TEXT PRIMARY KEY,
                nome TEXT NOT NULL,
                sobrenome TEXT NOT NULL,
                email TEXT NOT NULL UNIQUE,
                senha TEXT NOT NULL
            );
        """;

        String tabelaExame = """
            CREATE TABLE IF NOT EXISTS Exame (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nomeCompleto TEXT NOT NULL,
                cpf NUMERIC NOT NULL,
                dataNascimento TEXT NOT NULL,
                endereco TEXT NOT NULL,
                telefone TEXT NOT NULL,
                email TEXT NOT NULL,
                peso REAL NOT NULL,
                altura REAL NOT NULL,
                url_img TEXT NOT NULL,
                registroFuncionario TEXT NOT NULL,
                FOREIGN KEY (registroFuncionario) REFERENCES Funcionario (registro)
            );
        """;

        String tabelaLaudo = """
            CREATE TABLE IF NOT EXISTS Laudo (
                idExame INTEGER PRIMARY KEY,
                texto_laudo TEXT NOT NULL,
                crmMedico TEXT NOT NULL,
                FOREIGN KEY (idExame) REFERENCES Exame (id),
                FOREIGN KEY (crmMedico) REFERENCES Medico (crm)
            );
        """;

        try (Connection conexao = ConexaoSQLite.conectar();
             Statement stmt = conexao.createStatement()) {

            // Cria cada tabela
            stmt.execute(tabelaFuncionario);
            stmt.execute(tabelaMedico);
            stmt.execute(tabelaExame);
            stmt.execute(tabelaLaudo);

            System.out.println("Tabelas verificadas/criadas com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        criarTabelas();
    }
}
