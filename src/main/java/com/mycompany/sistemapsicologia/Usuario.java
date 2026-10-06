package com.mycompany.sistemapsicologia;

public class Usuario {

    private int id;
    private String email;
    private String senha;

    public Usuario(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
