package com.mycompany.sistemapsicologia;

import java.util.Scanner;

public class SistemaPsicologia {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String nomePaciente = "";
        String cpfPaciente = "";
        String telefonePaciente = "";

        String nomePsicologo = "Dra. Maria Souza";
        String especialidade = "Psicologia Clínica";

        String dataConsulta = "";
        String horarioConsulta = "";

        int opcao;

        do {

            System.out.println("\n======================================");
            System.out.println("   SISTEMA DE AGENDAMENTO");
            System.out.println("   CONSULTORIO DE PSICOLOGIA");
            System.out.println("======================================");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Ver psicologo");
            System.out.println("3 - Agendar consulta");
            System.out.println("4 - Ver consulta");
            System.out.println("5 - Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRO DE PACIENTE ---");

                    System.out.print("Nome: ");
                    nomePaciente = entrada.nextLine();

                    System.out.print("CPF: ");
                    cpfPaciente = entrada.nextLine();

                    System.out.print("Telefone: ");
                    telefonePaciente = entrada.nextLine();

                    System.out.println("\nPaciente cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.println("\n--- PSICOLOGO ---");
                    System.out.println("Nome: " + nomePsicologo);
                    System.out.println("Especialidade: " + especialidade);

                    break;

                case 3:

                    if (nomePaciente.isEmpty()) {

                        System.out.println("\nVoce precisa cadastrar um paciente primeiro!");

                    } else {

                        System.out.println("\n--- AGENDAMENTO DE CONSULTA ---");

                        System.out.println("Paciente: " + nomePaciente);
                        System.out.println("Psicologo: " + nomePsicologo);

                        System.out.print("Digite a data da consulta: ");
                        dataConsulta = entrada.nextLine();

                        System.out.print("Digite o horario da consulta: ");
                        horarioConsulta = entrada.nextLine();

                        System.out.println("\nConsulta agendada com sucesso!");

                    }

                    break;

                case 4:

                    if (dataConsulta.isEmpty()) {

                        System.out.println("\nNenhuma consulta foi agendada.");

                    } else {

                        System.out.println("\n--- CONSULTA AGENDADA ---");
                        System.out.println("Paciente: " + nomePaciente);
                        System.out.println("CPF: " + cpfPaciente);
                        System.out.println("Telefone: " + telefonePaciente);
                        System.out.println("Psicologo: " + nomePsicologo);
                        System.out.println("Especialidade: " + especialidade);
                        System.out.println("Data: " + dataConsulta);
                        System.out.println("Horario: " + horarioConsulta);
                        System.out.println("Status: Agendada");

                    }

                    break;

                case 5:

                    System.out.println("\nSistema encerrado.");
                    break;

                default:

                    System.out.println("\nOpcao invalida!");

            }

        } while (opcao != 5);

        entrada.close();
    }
}