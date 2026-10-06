package com.mycompany.sistemapsicologia;

public class Psicologo {

    private int id;
    private String nome;
    private String crp;
    private String especialidade;
    private String telefone;

    public Psicologo(int id, String nome, String crp,
                     String especialidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.crp = crp;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCrp() {
        return crp;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }
}