package com.mycompany.sistemapsicologia;

public class Paciente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    public Paciente(int id, String nome, String cpf, String telefone,
                    String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
