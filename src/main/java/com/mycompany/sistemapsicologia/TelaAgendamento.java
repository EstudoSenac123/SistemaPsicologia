package com.mycompany.sistemapsicologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaAgendamento extends JFrame {

    // =========================================================
    // COMPONENTES PARA ATUALIZAÇÃO DO TEMA
    // =========================================================

    private JPanel principal;
    private JPanel topo;
    private JPanel menu;
    private JPanel conteudo;
    private JPanel formulario;
    private JPanel botoes;

    private JLabel titulo;
    private JLabel subtitulo;
    private JLabel site;

    private JLabel logo;
    private JLabel logo2;
    private JLabel iniciais;
    private JLabel nome;
    private JLabel email;

    private JLabel tituloPagina;
    private JLabel descricao;

    private JLabel labelPaciente;
    private JLabel labelEmail;
    private JLabel labelPsicologo;
    private JLabel labelData;
    private JLabel labelHorario;

    private JComboBox<PacienteItem> paciente;
    private JComboBox<String> psicologo;
    private JTextField campoData;
    private JComboBox<String> horario;

    private JButton inicio;
    private JButton agendar;
    private JButton consultas;
    private JButton perfil;
    private JButton sair;

    private JButton voltar;
    private JButton confirmar;

    private int pacienteSelecionadoId = -1;

    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public TelaAgendamento() {

        setTitle("Agendamento Psicológico");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        montarTela();

        carregarPacientes();

        atualizarCores();
    }

    // =========================================================
    // MONTAR TELA
    // =========================================================

    private void montarTela() {

        principal = new JPanel(new BorderLayout());

        // =========================================================
        // TOPO
        // =========================================================

        topo = new JPanel(new BorderLayout());

        topo.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0,
                new Color(220, 225, 230)
        ));

        topo.setPreferredSize(
                new Dimension(1000, 75)
        );

        JPanel tituloTopo = new JPanel();

        tituloTopo.setOpaque(false);

        tituloTopo.setLayout(
                new BoxLayout(
                        tituloTopo,
                        BoxLayout.Y_AXIS
                )
        );

        tituloTopo.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 25, 8, 0
                )
        );

        titulo = new JLabel(
                "Agendamento Psicológico"
        );

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        21
                )
        );

        subtitulo = new JLabel(
                "Projeto UX/UI — Sistema de Agendamento"
        );

        subtitulo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        tituloTopo.add(titulo);

        tituloTopo.add(
                Box.createVerticalStrut(3)
        );

        tituloTopo.add(subtitulo);

        topo.add(
                tituloTopo,
                BorderLayout.WEST
        );

        site = new JLabel(
                "agendamentopsicologico.com.br"
        );

        site.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        site.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 0, 0, 25
                )
        );

        topo.add(
                site,
                BorderLayout.EAST
        );

        principal.add(
                topo,
                BorderLayout.NORTH
        );

        // =========================================================
        // MENU LATERAL
        // =========================================================

        menu = new JPanel();

        menu.setPreferredSize(
                new Dimension(230, 625)
        );

        menu.setLayout(
                new BoxLayout(
                        menu,
                        BoxLayout.Y_AXIS
                )
        );

        menu.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 18, 20, 18
                )
        );

        logo = new JLabel(
                "Agendamento"
        );

        logo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        logo.setAlignmentX(
                LEFT_ALIGNMENT
        );

        logo2 = new JLabel(
                "Psicológico"
        );

        logo2.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        logo2.setAlignmentX(
                LEFT_ALIGNMENT
        );

        menu.add(logo);
        menu.add(logo2);

        menu.add(
                Box.createVerticalStrut(35)
        );

        inicio = criarBotaoMenu(
                "⌂  Início"
        );

        agendar = criarBotaoMenu(
                "Agendar consulta"
        );

        consultas = criarBotaoMenu(
                "Minhas consultas"
        );

        perfil = criarBotaoMenu(
                "Meu perfil"
        );

        menu.add(inicio);

        menu.add(
                Box.createVerticalStrut(8)
        );

        menu.add(agendar);

        menu.add(
                Box.createVerticalStrut(8)
        );

        menu.add(consultas);

        menu.add(
                Box.createVerticalStrut(8)
        );

        menu.add(perfil);

        menu.add(
                Box.createVerticalGlue()
        );

        iniciais = new JLabel(
                "MP",
                SwingConstants.CENTER
        );

        iniciais.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        iniciais.setOpaque(true);

        iniciais.setPreferredSize(
                new Dimension(42, 42)
        );

        iniciais.setMaximumSize(
                new Dimension(42, 42)
        );

        iniciais.setAlignmentX(
                LEFT_ALIGNMENT
        );

        nome = new JLabel(
                "Paciente"
        );

        nome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        nome.setAlignmentX(
                LEFT_ALIGNMENT
        );

        email = new JLabel(
                "Selecione um paciente"
        );

        email.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        11
                )
        );

        email.setAlignmentX(
                LEFT_ALIGNMENT
        );

        sair = criarBotaoMenu(
                "↩  Sair"
        );

        menu.add(iniciais);

        menu.add(
                Box.createVerticalStrut(8)
        );

        menu.add(nome);
        menu.add(email);

        menu.add(
                Box.createVerticalStrut(15)
        );

        menu.add(sair);

        principal.add(
                menu,
                BorderLayout.WEST
        );

        // =========================================================
        // CONTEÚDO
        // =========================================================

        conteudo = new JPanel();

        conteudo.setLayout(
                new BoxLayout(
                        conteudo,
                        BoxLayout.Y_AXIS
                )
        );

        conteudo.setBorder(
                BorderFactory.createEmptyBorder(
                        28, 35, 25, 35
                )
        );

        tituloPagina = new JLabel(
                "Agendar consulta"
        );

        tituloPagina.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        tituloPagina.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(tituloPagina);

        conteudo.add(
                Box.createVerticalStrut(5)
        );

        descricao = new JLabel(
                "Escolha o paciente, psicólogo, data e horário da sua consulta."
        );

        descricao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        descricao.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(descricao);

        conteudo.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // FORMULÁRIO
        // =========================================================

        formulario = new JPanel();

        formulario.setLayout(
                new BoxLayout(
                        formulario,
                        BoxLayout.Y_AXIS
                )
        );

        formulario.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                18, 25, 18, 25
                        )
                )
        );

        formulario.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        390
                )
        );

        formulario.setAlignmentX(
                LEFT_ALIGNMENT
        );

        // =========================================================
        // PACIENTE
        // =========================================================

        labelPaciente = criarLabel(
                "Paciente"
        );

        formulario.add(labelPaciente);

        formulario.add(
                Box.createVerticalStrut(5)
        );

        paciente = new JComboBox<>();

        configurarCampo(paciente);

        formulario.add(paciente);

        paciente.addActionListener(
                e -> atualizarPacienteSelecionado()
        );

        formulario.add(
                Box.createVerticalStrut(12)
        );

        // =========================================================
        // E-MAIL
        // =========================================================

        labelEmail = criarLabel(
                "E-mail"
        );

        formulario.add(labelEmail);

        formulario.add(
                Box.createVerticalStrut(5)
        );

        email.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        email.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 225, 230)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 10, 8, 10
                        )
                )
        );

        formulario.add(email);

        formulario.add(
                Box.createVerticalStrut(12)
        );

        // =========================================================
        // PSICÓLOGO
        // =========================================================

        labelPsicologo = criarLabel(
                "Psicólogo"
        );

        formulario.add(labelPsicologo);

        formulario.add(
                Box.createVerticalStrut(5)
        );

        psicologo = new JComboBox<>();

        psicologo.addItem(
                "Selecione um psicólogo"
        );

        psicologo.addItem(
                "Dra. Ana Carvalho"
        );

        psicologo.addItem(
                "Dra. Maria Souza"
        );

        configurarCampo(psicologo);

        formulario.add(psicologo);

        formulario.add(
                Box.createVerticalStrut(12)
        );

        // =========================================================
        // DATA
        // =========================================================

        labelData = criarLabel(
                "Data da consulta"
        );

        formulario.add(labelData);

        formulario.add(
                Box.createVerticalStrut(5)
        );

        campoData = new JTextField();

        campoData.setText(
                "22/09/2026"
        );

        configurarCampo(campoData);

        formulario.add(campoData);

        formulario.add(
                Box.createVerticalStrut(12)
        );

        // =========================================================
        // HORÁRIO
        // =========================================================

        labelHorario = criarLabel(
                "Horário"
        );

        formulario.add(labelHorario);

        formulario.add(
                Box.createVerticalStrut(5)
        );

        horario = new JComboBox<>();

        horario.addItem(
                "Selecione um horário"
        );

        horario.addItem("08:00");
        horario.addItem("09:00");
        horario.addItem("10:00");
        horario.addItem("11:00");
        horario.addItem("13:00");
        horario.addItem("14:00");
        horario.addItem("15:00");
        horario.addItem("16:00");
        horario.addItem("17:00");

        configurarCampo(horario);

        formulario.add(horario);

        conteudo.add(formulario);

        conteudo.add(
                Box.createVerticalStrut(18)
        );

        // =========================================================
        // BOTÕES
        // =========================================================

        botoes = new JPanel(
                new GridLayout(
                        1, 2, 12, 0
                )
        );

        botoes.setOpaque(false);

        botoes.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        botoes.setAlignmentX(
                LEFT_ALIGNMENT
        );

        voltar = new JButton(
                "Voltar"
        );

        voltar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        voltar.setFocusPainted(false);

        voltar.setBorder(
                BorderFactory.createLineBorder(
                        new Color(210, 220, 225)
                )
        );

        confirmar = new JButton(
                "Agendar consulta"
        );

        confirmar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        confirmar.setFocusPainted(false);

        confirmar.setBorderPainted(false);

        botoes.add(voltar);
        botoes.add(confirmar);

        conteudo.add(botoes);

        principal.add(
                conteudo,
                BorderLayout.CENTER
        );

        setContentPane(principal);

        // =========================================================
        // AÇÕES DOS BOTÕES
        // =========================================================

        inicio.addActionListener(
                e -> voltarPrincipal()
        );

        voltar.addActionListener(
                e -> voltarPrincipal()
        );

        agendar.addActionListener(
                e -> {
                    // Já estamos na tela de agendamento.
                }
        );

        consultas.addActionListener(
                e -> abrirConsultas()
        );

        perfil.addActionListener(
                e -> abrirPerfil()
        );

        sair.addActionListener(e -> {

            dispose();

            new TelaLoginManual()
                    .setVisible(true);
        });

        confirmar.addActionListener(
                e -> confirmarAgendamento()
        );
    }

    // =========================================================
    // CARREGAR PACIENTES DO MYSQL
    // =========================================================

    private void carregarPacientes() {

        paciente.removeAllItems();

        BancoDeDados banco = new BancoDeDados();

        banco.conectar();

        if (banco.getConexao() == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível conectar ao banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String sql =
                "SELECT id, nome, email "
                + "FROM paciente "
                + "ORDER BY nome";

        try (
                PreparedStatement comando =
                        banco.getConexao()
                                .prepareStatement(sql);

                ResultSet resultado =
                        comando.executeQuery()
        ) {

            while (resultado.next()) {

                int id =
                        resultado.getInt("id");

                String nomePaciente =
                        resultado.getString("nome");

                String emailPaciente =
                        resultado.getString("email");

                paciente.addItem(
                        new PacienteItem(
                                id,
                                nomePaciente,
                                emailPaciente
                        )
                );
            }

            if (paciente.getItemCount() == 0) {

                paciente.addItem(
                        new PacienteItem(
                                -1,
                                "Nenhum paciente cadastrado",
                                ""
                        )
                );

                pacienteSelecionadoId = -1;

                email.setText(
                        "Nenhum paciente cadastrado"
                );

                nome.setText("Paciente");

                iniciais.setText("P");

            } else {

                paciente.setSelectedIndex(0);

                atualizarPacienteSelecionado();
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar os pacientes.\n\n"
                    + "Detalhes: "
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } finally {

            banco.desconectar();
        }
    }

    // =========================================================
    // ATUALIZAR PACIENTE SELECIONADO
    // =========================================================

    private void atualizarPacienteSelecionado() {

        PacienteItem selecionado =
                (PacienteItem) paciente.getSelectedItem();

        if (selecionado == null) {
            return;
        }

        pacienteSelecionadoId =
                selecionado.getId();

        if (pacienteSelecionadoId == -1) {

            email.setText(
                    "Nenhum paciente cadastrado"
            );

            nome.setText("Paciente");

            iniciais.setText("P");

            return;
        }

        // Atualiza e-mail
        if (selecionado.getEmail() == null
                || selecionado.getEmail().trim().isEmpty()) {

            email.setText(
                    "E-mail não informado"
            );

        } else {

            email.setText(
                    selecionado.getEmail()
            );
        }

        // Atualiza nome no menu lateral
        nome.setText(
                selecionado.getNome()
        );

        // Atualiza iniciais
        String nomeCompleto =
                selecionado.getNome().trim();

        if (!nomeCompleto.isEmpty()) {

            String[] partes =
                    nomeCompleto.split("\\s+");

            if (partes.length >= 2) {

                String primeira =
                        partes[0]
                                .substring(0, 1)
                                .toUpperCase();

                String ultima =
                        partes[partes.length - 1]
                                .substring(0, 1)
                                .toUpperCase();

                iniciais.setText(
                        primeira + ultima
                );

            } else {

                iniciais.setText(
                        nomeCompleto
                                .substring(0, 1)
                                .toUpperCase()
                );
            }
        }
    }

    // =========================================================
    // CONFIRMAR AGENDAMENTO
    // =========================================================

    private void confirmarAgendamento() {

        if (pacienteSelecionadoId == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um paciente.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (psicologo.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um psicólogo.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String data =
                campoData.getText().trim();

        if (data.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe a data da consulta.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (horario.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecione um horário.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String nomePsicologo =
                psicologo.getSelectedItem()
                        .toString();

        String horarioSelecionado =
                horario.getSelectedItem()
                        .toString();

        PacienteItem pacienteAtual =
                (PacienteItem) paciente.getSelectedItem();

        BancoDeDados banco =
                new BancoDeDados();

        banco.conectar();

        if (banco.getConexao() == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível conectar ao banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {

            // =====================================================
            // LOCALIZAR PSICÓLOGO
            // =====================================================

            int psicologoId = -1;

            String sqlPsicologo =
                    "SELECT id "
                    + "FROM psicologo "
                    + "WHERE nome = ?";

            try (
                    PreparedStatement comando =
                            banco.getConexao()
                                    .prepareStatement(
                                            sqlPsicologo
                                    )
            ) {

                comando.setString(
                        1,
                        nomePsicologo
                );

                try (
                        ResultSet resultado =
                                comando.executeQuery()
                ) {

                    if (resultado.next()) {

                        psicologoId =
                                resultado.getInt("id");
                    }
                }
            }

            // =====================================================
            // CADASTRAR PSICÓLOGO SE NÃO EXISTIR
            // =====================================================

            if (psicologoId == -1) {

                String crp;

                if (nomePsicologo.equals(
                        "Dra. Maria Souza")) {

                    crp = "CRP 06/12345";

                } else {

                    crp = "CRP 00/00000";
                }

                String sqlInserir =
                        "INSERT INTO psicologo "
                        + "(nome, crp, especialidade, telefone) "
                        + "VALUES (?, ?, ?, ?)";

                try (
                        PreparedStatement comando =
                                banco.getConexao()
                                        .prepareStatement(
                                                sqlInserir,
                                                java.sql.Statement
                                                        .RETURN_GENERATED_KEYS
                                        )
                ) {

                    comando.setString(
                            1,
                            nomePsicologo
                    );

                    comando.setString(
                            2,
                            crp
                    );

                    comando.setString(
                            3,
                            "Psicologia Clínica"
                    );

                    comando.setString(
                            4,
                            ""
                    );

                    comando.executeUpdate();

                    try (
                            ResultSet chaves =
                                    comando.getGeneratedKeys()
                    ) {

                        if (chaves.next()) {

                            psicologoId =
                                    chaves.getInt(1);
                        }
                    }
                }
            }

            // =====================================================
            // VERIFICAR HORÁRIO
            // =====================================================

            String sqlVerificar =
                    "SELECT id "
                    + "FROM consulta "
                    + "WHERE psicologo_id = ? "
                    + "AND data = ? "
                    + "AND horario = ? "
                    + "AND status = 'Agendada'";

            try (
                    PreparedStatement comando =
                            banco.getConexao()
                                    .prepareStatement(
                                            sqlVerificar
                                    )
            ) {

                comando.setInt(
                        1,
                        psicologoId
                );

                comando.setString(
                        2,
                        data
                );

                comando.setString(
                        3,
                        horarioSelecionado
                );

                try (
                        ResultSet resultado =
                                comando.executeQuery()
                ) {

                    if (resultado.next()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Esse horário já está ocupado "
                                + "para esse psicólogo.\n\n"
                                + "Escolha outro horário.",
                                "Horário ocupado",
                                JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }
                }
            }

            // =====================================================
            // SALVAR CONSULTA
            // =====================================================

            String sqlConsulta =
                    "INSERT INTO consulta "
                    + "(data, horario, status, "
                    + "paciente_id, psicologo_id) "
                    + "VALUES (?, ?, 'Agendada', ?, ?)";

            try (
                    PreparedStatement comando =
                            banco.getConexao()
                                    .prepareStatement(
                                            sqlConsulta
                                    )
            ) {

                comando.setString(
                        1,
                        data
                );

                comando.setString(
                        2,
                        horarioSelecionado
                );

                comando.setInt(
                        3,
                        pacienteSelecionadoId
                );

                comando.setInt(
                        4,
                        psicologoId
                );

                comando.executeUpdate();
            }

            // =====================================================
            // CONFIRMAÇÃO
            // =====================================================

            JOptionPane.showMessageDialog(
                    this,
                    "Consulta agendada com sucesso!\n\n"
                    + "Paciente: "
                    + pacienteAtual.getNome()
                    + "\nE-mail: "
                    + pacienteAtual.getEmail()
                    + "\nPsicólogo: "
                    + nomePsicologo
                    + "\nData: "
                    + data
                    + "\nHorário: "
                    + horarioSelecionado,
                    "Agendamento realizado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            psicologo.setSelectedIndex(0);

            horario.setSelectedIndex(0);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao salvar o agendamento no MySQL.\n\n"
                    + "Detalhes: "
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } finally {

            banco.desconectar();
        }
    }

    // =========================================================
    // ATUALIZAR CORES
    // =========================================================

    public void atualizarCores() {

        Color corPrincipal =
                TemaSistema.getCorPrincipal();

        Color corEscura =
                TemaSistema.getCorEscura();

        Color fundo =
                TemaSistema.getCorFundo();

        Color texto =
                TemaSistema.getCorTexto();

        Color painel =
                TemaSistema.getCorPainel();

        boolean escuro =
                TemaSistema.getTemaAtual()
                        .equals("ESCURO");

        principal.setBackground(fundo);

        topo.setBackground(painel);

        menu.setBackground(corPrincipal);

        conteudo.setBackground(fundo);

        formulario.setBackground(painel);

        titulo.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        subtitulo.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        site.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        logo.setForeground(Color.WHITE);

        logo2.setForeground(Color.WHITE);

        iniciais.setBackground(Color.WHITE);

        iniciais.setForeground(corEscura);

        nome.setForeground(Color.WHITE);

        email.setForeground(
                new Color(225, 240, 245)
        );

        atualizarBotaoMenu(inicio);
        atualizarBotaoMenu(agendar);
        atualizarBotaoMenu(consultas);
        atualizarBotaoMenu(perfil);
        atualizarBotaoMenu(sair);

        tituloPagina.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        descricao.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        labelPaciente.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        labelEmail.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        labelPsicologo.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        labelData.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        labelHorario.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        paciente.setBackground(painel);

        paciente.setForeground(texto);

        psicologo.setBackground(painel);

        psicologo.setForeground(texto);

        campoData.setBackground(painel);

        campoData.setForeground(texto);

        campoData.setCaretColor(texto);

        horario.setBackground(painel);

        horario.setForeground(texto);

        email.setBackground(painel);

        email.setForeground(texto);

        formulario.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                escuro
                                        ? new Color(80, 88, 98)
                                        : new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                18, 25, 18, 25
                        )
                )
        );

        voltar.setBackground(painel);

        voltar.setForeground(
                escuro
                        ? Color.WHITE
                        : corEscura
        );

        voltar.setBorder(
                BorderFactory.createLineBorder(
                        escuro
                                ? new Color(80, 88, 98)
                                : new Color(210, 220, 225)
                )
        );

        confirmar.setBackground(
                corPrincipal
        );

        confirmar.setForeground(
                Color.WHITE
        );

        repaint();
    }

    // =========================================================
    // BOTÃO MENU
    // =========================================================

    private JButton criarBotaoMenu(
            String texto
    ) {

        JButton botao =
                new JButton(texto);

        botao.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        botao.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        botao.setBorderPainted(false);

        botao.setFocusPainted(false);

        botao.setOpaque(true);

        botao.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        botao.setPreferredSize(
                new Dimension(
                        190,
                        42
                )
        );

        botao.setMargin(
                new Insets(
                        0, 10, 0, 0
                )
        );

        botao.setAlignmentX(
                LEFT_ALIGNMENT
        );

        botao.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        return botao;
    }

    private void atualizarBotaoMenu(
            JButton botao
    ) {

        botao.setBackground(
                TemaSistema.getCorPrincipal()
        );

        botao.setForeground(
                Color.WHITE
        );
    }

    // =========================================================
    // LABEL
    // =========================================================

    private JLabel criarLabel(
            String texto
    ) {

        JLabel label =
                new JLabel(texto);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        label.setAlignmentX(
                LEFT_ALIGNMENT
        );

        return label;
    }

    // =========================================================
    // CAMPOS
    // =========================================================

    private void configurarCampo(
            javax.swing.JComponent campo
    ) {

        campo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        campo.setPreferredSize(
                new Dimension(
                        500,
                        38
                )
        );

        campo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        campo.setAlignmentX(
                LEFT_ALIGNMENT
        );
    }

    // =========================================================
    // VOLTAR PARA PRINCIPAL
    // =========================================================

    private void voltarPrincipal() {

        dispose();

        new TelaPrincipal()
                .setVisible(true);
    }

    // =========================================================
    // ABRIR CONSULTAS
    // =========================================================

    private void abrirConsultas() {

        dispose();

        new TelaConsultas()
                .setVisible(true);
    }

    // =========================================================
    // ABRIR PERFIL
    // =========================================================

    private void abrirPerfil() {

        dispose();

        new TelaPerfil()
                .setVisible(true);
    }

    // =========================================================
    // CLASSE PARA REPRESENTAR O PACIENTE
    // =========================================================

    private static class PacienteItem {

        private int id;
        private String nome;
        private String email;

        public PacienteItem(
                int id,
                String nome,
                String email
        ) {

            this.id = id;
            this.nome = nome;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {

            if (email == null
                    || email.trim().isEmpty()) {

                return nome;
            }

            return nome
                    + " — "
                    + email;
        }
    }

    // =========================================================
    // TESTE
    // =========================================================

    public static void main(
            String[] args
    ) {

        java.awt.EventQueue.invokeLater(
                () -> {

                    new TelaAgendamento()
                            .setVisible(true);
                }
        );
    }
}