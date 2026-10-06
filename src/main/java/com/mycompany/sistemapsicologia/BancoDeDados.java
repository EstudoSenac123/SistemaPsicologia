package com.mycompany.sistemapsicologia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {

    private Connection conexao;

    private final String URL = "jdbc:mysql://localhost:3306/sistemapsicologia";
    private final String USUARIO = "root";
    private final String SENHA = "Senac";

    public void conectar() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Banco de dados conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Banco de dados desconectado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar do banco de dados.");
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}