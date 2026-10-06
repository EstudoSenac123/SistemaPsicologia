package com.mycompany.sistemapsicologia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        BancoDeDados banco = new BancoDeDados();
        banco.conectar();

        if (banco.getConexao() == null) {
            System.out.println("Nao foi possivel iniciar o sistema.");
            return;
        }

        Scanner entrada = new Scanner(System.in);

        Paciente paciente = null;

        Psicologo psicologo = new Psicologo(
                1,
                "Dra. Maria Souza",
                "CRP 06/12345",
                "Psicologia Clinica",
                "999999999"
        );

        Consulta consulta = null;

        /*
         * Verifica se o psicologo ja existe no MySQL.
         * Se nao existir, cadastra.
         */
        String sqlVerificarPsicologo =
                "SELECT id FROM psicologo WHERE crp = ?";

        try {

            PreparedStatement comando =
                    banco.getConexao().prepareStatement(
                            sqlVerificarPsicologo
                    );

            comando.setString(1, psicologo.getCrp());

            ResultSet resultado = comando.executeQuery();

            if (!resultado.next()) {

                String sqlPsicologo =
                        "INSERT INTO psicologo "
                        + "(nome, crp, especialidade, telefone) "
                        + "VALUES (?, ?, ?, ?)";

                PreparedStatement inserir =
                        banco.getConexao().prepareStatement(
                                sqlPsicologo
                        );

                inserir.setString(1, psicologo.getNome());
                inserir.setString(2, psicologo.getCrp());
                inserir.setString(3, psicologo.getEspecialidade());
                inserir.setString(4, psicologo.getTelefone());

                inserir.executeUpdate();

                inserir.close();

                System.out.println("Psicologo salvo no MySQL!");

            } else {

                System.out.println(
                        "Psicologo ja cadastrado no MySQL."
                );
            }

            resultado.close();
            comando.close();

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao verificar psicologo no MySQL."
            );

            System.out.println(
                    "Detalhes: " + e.getMessage()
            );
        }

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
                    String nome = entrada.nextLine();

                    System.out.print("CPF: ");
                    String cpf = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Email: ");
                    String email = entrada.nextLine();

                    System.out.print("Senha: ");
                    String senha = entrada.nextLine();

                    paciente = new Paciente(
                            1,
                            nome,
                            cpf,
                            telefone,
                            email,
                            senha
                    );

                    String sqlPaciente =
                            "INSERT INTO paciente "
                            + "(nome, cpf, telefone, email, senha) "
                            + "VALUES (?, ?, ?, ?, ?)";

                    try {

                        PreparedStatement comando =
                                banco.getConexao().prepareStatement(
                                        sqlPaciente
                                );

                        comando.setString(1, nome);
                        comando.setString(2, cpf);
                        comando.setString(3, telefone);
                        comando.setString(4, email);
                        comando.setString(5, senha);

                        comando.executeUpdate();

                        comando.close();

                        System.out.println(
                                "\nPaciente cadastrado e salvo no MySQL!"
                        );

                    } catch (SQLException e) {

                        System.out.println(
                                "\nErro ao salvar paciente no MySQL."
                        );

                        System.out.println(
                                "Detalhes: " + e.getMessage()
                        );
                    }

                    break;

                case 2:

                    System.out.println("\n--- PSICOLOGO ---");

                    System.out.println(
                            "Nome: " + psicologo.getNome()
                    );

                    System.out.println(
                            "CRP: " + psicologo.getCrp()
                    );

                    System.out.println(
                            "Especialidade: "
                            + psicologo.getEspecialidade()
                    );

                    System.out.println(
                            "Telefone: "
                            + psicologo.getTelefone()
                    );

                    break;

                case 3:

                    if (paciente == null) {

                        System.out.println(
                                "\nVoce precisa cadastrar um paciente primeiro!"
                        );

                    } else {

                        System.out.println(
                                "\n--- AGENDAMENTO DE CONSULTA ---"
                        );

                        System.out.println(
                                "Paciente: "
                                + paciente.getNome()
                        );

                        System.out.println(
                                "Psicologo: "
                                + psicologo.getNome()
                        );

                        System.out.print(
                                "Digite a data da consulta: "
                        );

                        String data = entrada.nextLine();

                        System.out.print(
                                "Digite o horario da consulta: "
                        );

                        String horario = entrada.nextLine();

                        consulta = new Consulta(
                                1,
                                data,
                                horario,
                                "Agendada",
                                paciente,
                                psicologo
                        );

                        /*
                         * Busca o ID real do paciente no MySQL
                         * usando o CPF.
                         */
                        int pacienteId = 0;

                        String sqlBuscarPaciente =
                                "SELECT id FROM paciente WHERE cpf = ?";

                        try {

                            PreparedStatement buscarPaciente =
                                    banco.getConexao().prepareStatement(
                                            sqlBuscarPaciente
                                    );

                            buscarPaciente.setString(1, cpfDoPaciente(paciente));

                            ResultSet resultadoPaciente =
                                    buscarPaciente.executeQuery();

                            if (resultadoPaciente.next()) {

                                pacienteId =
                                        resultadoPaciente.getInt("id");
                            }

                            resultadoPaciente.close();
                            buscarPaciente.close();

                        } catch (SQLException e) {

                            System.out.println(
                                    "Erro ao buscar paciente."
                            );

                            System.out.println(
                                    "Detalhes: " + e.getMessage()
                            );
                        }

                        /*
                         * Busca o ID real do psicologo no MySQL
                         * usando o CRP.
                         */
                        int psicologoId = 0;

                        String sqlBuscarPsicologo =
                                "SELECT id FROM psicologo WHERE crp = ?";

                        try {

                            PreparedStatement buscarPsicologo =
                                    banco.getConexao().prepareStatement(
                                            sqlBuscarPsicologo
                                    );

                            buscarPsicologo.setString(
                                    1,
                                    psicologo.getCrp()
                            );

                            ResultSet resultadoPsicologo =
                                    buscarPsicologo.executeQuery();

                            if (resultadoPsicologo.next()) {

                                psicologoId =
                                        resultadoPsicologo.getInt("id");
                            }

                            resultadoPsicologo.close();
                            buscarPsicologo.close();

                        } catch (SQLException e) {

                            System.out.println(
                                    "Erro ao buscar psicologo."
                            );

                            System.out.println(
                                    "Detalhes: " + e.getMessage()
                            );
                        }

                        /*
                         * Salva a consulta no MySQL.
                         */
                        if (pacienteId > 0 && psicologoId > 0) {

                            String sqlConsulta =
                                    "INSERT INTO consulta "
                                    + "(data, horario, status, "
                                    + "paciente_id, psicologo_id) "
                                    + "VALUES (?, ?, ?, ?, ?)";

                            try {

                                PreparedStatement comandoConsulta =
                                        banco.getConexao().prepareStatement(
                                                sqlConsulta
                                        );

                                comandoConsulta.setString(1, data);
                                comandoConsulta.setString(2, horario);
                                comandoConsulta.setString(
                                        3,
                                        "Agendada"
                                );
                                comandoConsulta.setInt(
                                        4,
                                        pacienteId
                                );
                                comandoConsulta.setInt(
                                        5,
                                        psicologoId
                                );

                                comandoConsulta.executeUpdate();

                                comandoConsulta.close();

                                System.out.println(
                                        "\nConsulta agendada e salva no MySQL!"
                                );

                            } catch (SQLException e) {

                                System.out.println(
                                        "\nErro ao salvar consulta no MySQL."
                                );

                                System.out.println(
                                        "Detalhes: " + e.getMessage()
                                );
                            }

                        } else {

                            System.out.println(
                                    "\nNao foi possivel encontrar "
                                    + "paciente ou psicologo no banco."
                            );
                        }
                    }

                    break;

                case 4:

                    if (consulta == null) {

                        System.out.println(
                                "\nNenhuma consulta foi agendada."
                        );

                    } else {

                        System.out.println(
                                "\n--- CONSULTA AGENDADA ---"
                        );

                        System.out.println(
                                "Paciente: "
                                + consulta.getPaciente().getNome()
                        );

                        System.out.println(
                                "CPF: "
                                + consulta.getPaciente().getCpf()
                        );

                        System.out.println(
                                "Telefone: "
                                + consulta.getPaciente().getTelefone()
                        );

                        System.out.println(
                                "Psicologo: "
                                + consulta.getPsicologo().getNome()
                        );

                        System.out.println(
                                "Especialidade: "
                                + consulta.getPsicologo().getEspecialidade()
                        );

                        System.out.println(
                                "Data: "
                                + consulta.getData()
                        );

                        System.out.println(
                                "Horario: "
                                + consulta.getHorario()
                        );

                        System.out.println(
                                "Status: "
                                + consulta.getStatus()
                        );
                    }

                    break;

                case 5:

                    System.out.println(
                            "\nSistema encerrado."
                    );

                    banco.desconectar();

                    break;

                default:

                    System.out.println(
                            "\nOpcao invalida!"
                    );
            }

        } while (opcao != 5);

        entrada.close();
    }

    /*
     * Retorna o CPF do paciente cadastrado.
     */
    private static String cpfDoPaciente(Paciente paciente) {

        return paciente.getCpf();
    }
}