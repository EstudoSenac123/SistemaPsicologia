package com.mycompany.sistemapsicologia;

public class Consulta {

    private int id;
    private String data;
    private String horario;
    private String status;
    private Paciente paciente;
    private Psicologo psicologo;

    public Consulta(int id, String data, String horario,
                    String status, Paciente paciente,
                    Psicologo psicologo) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.paciente = paciente;
        this.psicologo = psicologo;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getStatus() {
        return status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }
}
