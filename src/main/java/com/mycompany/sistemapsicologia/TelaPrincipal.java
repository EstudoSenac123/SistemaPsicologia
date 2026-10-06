package com.mycompany.sistemapsicologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

    // =========================================================
    // COMPONENTES
    // =========================================================

    private JPanel principal;
    private JPanel topo;
    private JPanel menu;
    private JPanel conteudo;
    private JPanel acoes;
    private JPanel consulta;
    private JPanel resumo;

    private JPanel tituloTopo;
    private JPanel usuario;
    private JPanel dadosConsulta;

    private JLabel site;
    private JLabel subtitulo;
    private JLabel cadeado;
    private JLabel logo;
    private JLabel logo2;
    private JLabel iniciais;
    private JLabel nome;
    private JLabel email;

    private JLabel data;
    private JLabel saudacao;
    private JLabel descricao;
    private JLabel proxima;
    private JLabel psicologa;
    private JLabel especialidade;
    private JLabel horario;
    private JLabel confirmada;
    private JLabel resumoTitulo;

    private JLabel iniciaisAna;

    private JButton inicio;
    private JButton agendar;
    private JButton consultas;
    private JButton perfil;
    private JButton sair;

    private JButton cardAgendar;
    private JButton cardConsultas;
    private JButton novaConsulta;

    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public TelaPrincipal() {

        setTitle("Agendamento Psicológico");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        montarTela();

        atualizarCores();
    }

    // =========================================================
    // MONTAR TELA
    // =========================================================

    private void montarTela() {

        principal = new JPanel(new BorderLayout());

        // =====================================================
        // TOPO
        // =====================================================

        topo = new JPanel(new BorderLayout());

        topo.setPreferredSize(
                new Dimension(1000, 75)
        );

        tituloTopo = new JPanel();

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

        site = new JLabel(
                "Agendamento Psicológico"
        );

        site.setFont(
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

        tituloTopo.add(site);

        tituloTopo.add(
                Box.createVerticalStrut(3)
        );

        tituloTopo.add(subtitulo);

        topo.add(
                tituloTopo,
                BorderLayout.WEST
        );

        cadeado = new JLabel(
                "agendamentopsicologico.com.br"
        );

        cadeado.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        cadeado.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 0, 0, 25
                )
        );

        topo.add(
                cadeado,
                BorderLayout.EAST
        );

        principal.add(
                topo,
                BorderLayout.NORTH
        );

        // =====================================================
        // MENU LATERAL
        // =====================================================

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

        usuario = new JPanel();

        usuario.setOpaque(false);

        usuario.setLayout(
                new BoxLayout(
                        usuario,
                        BoxLayout.Y_AXIS
                )
        );

        usuario.setAlignmentX(
                LEFT_ALIGNMENT
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
                "Maria Paciente"
        );

        nome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        nome.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 0, 0, 0
                )
        );

        nome.setAlignmentX(
                LEFT_ALIGNMENT
        );

        email = new JLabel(
                "maria@email.com"
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

        usuario.add(iniciais);
        usuario.add(nome);
        usuario.add(email);

        usuario.add(
                Box.createVerticalStrut(15)
        );

        usuario.add(sair);

        menu.add(usuario);

        principal.add(
                menu,
                BorderLayout.WEST
        );

        // =====================================================
        // CONTEÚDO
        // =====================================================

        conteudo = new JPanel();

        conteudo.setLayout(
                new BoxLayout(
                        conteudo,
                        BoxLayout.Y_AXIS
                )
        );

        conteudo.setBorder(
                BorderFactory.createEmptyBorder(
                        28, 30, 25, 30
                )
        );

        data = new JLabel(
                "Segunda-feira, 14 de setembro de 2026"
        );

        data.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        data.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(data);

        conteudo.add(
                Box.createVerticalStrut(15)
        );

        saudacao = new JLabel(
                "Olá, Maria! Seja bem-vinda!"
        );

        saudacao.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        saudacao.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(saudacao);

        conteudo.add(
                Box.createVerticalStrut(5)
        );

        descricao = new JLabel(
                "Como você está hoje? Gerencie suas consultas abaixo."
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
                Box.createVerticalStrut(22)
        );

        // =====================================================
        // CARDS
        // =====================================================

        acoes = new JPanel(
                new GridLayout(1, 2, 15, 0)
        );

        acoes.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        100
                )
        );

        acoes.setAlignmentX(
                LEFT_ALIGNMENT
        );

        cardAgendar = criarCard(
                "Agendar consulta",
                "Escolher psicólogo e horário"
        );

        cardConsultas = criarCard(
                "Minhas consultas",
                "Ver histórico e agendamentos"
        );

        acoes.add(cardAgendar);
        acoes.add(cardConsultas);

        conteudo.add(acoes);

        conteudo.add(
                Box.createVerticalStrut(22)
        );

        // =====================================================
        // PRÓXIMA CONSULTA
        // =====================================================

        proxima = new JLabel(
                "Próxima Consulta"
        );

        proxima.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        proxima.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(proxima);

        conteudo.add(
                Box.createVerticalStrut(10)
        );

        consulta = new JPanel(
                new BorderLayout()
        );

        consulta.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        120
                )
        );

        consulta.setAlignmentX(
                LEFT_ALIGNMENT
        );

        iniciaisAna = new JLabel(
                "AC",
                SwingConstants.CENTER
        );

        iniciaisAna.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        iniciaisAna.setOpaque(true);

        iniciaisAna.setPreferredSize(
                new Dimension(45, 45)
        );

        consulta.add(
                iniciaisAna,
                BorderLayout.WEST
        );

        dadosConsulta = new JPanel();

        dadosConsulta.setOpaque(false);

        dadosConsulta.setLayout(
                new BoxLayout(
                        dadosConsulta,
                        BoxLayout.Y_AXIS
                )
        );

        dadosConsulta.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 15, 0, 0
                )
        );

        psicologa = new JLabel(
                "Dra. Ana Carvalho"
        );

        psicologa.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        especialidade = new JLabel(
                "Terapia Cognitivo-Comportamental"
        );

        especialidade.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        horario = new JLabel(
                "22/09/2026    |    10:00"
        );

        horario.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        dadosConsulta.add(psicologa);

        dadosConsulta.add(
                Box.createVerticalStrut(3)
        );

        dadosConsulta.add(especialidade);

        dadosConsulta.add(
                Box.createVerticalStrut(8)
        );

        dadosConsulta.add(horario);

        consulta.add(
                dadosConsulta,
                BorderLayout.CENTER
        );

        confirmada = new JLabel(
                "Confirmada"
        );

        confirmada.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        confirmada.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 0, 0, 5
                )
        );

        consulta.add(
                confirmada,
                BorderLayout.EAST
        );

        conteudo.add(consulta);

        conteudo.add(
                Box.createVerticalStrut(10)
        );

        novaConsulta = new JButton(
                "+  Agendar nova consulta"
        );

        novaConsulta.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        novaConsulta.setBorderPainted(false);
        novaConsulta.setFocusPainted(false);

        novaConsulta.setAlignmentX(
                LEFT_ALIGNMENT
        );

        novaConsulta.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        conteudo.add(novaConsulta);

        conteudo.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // RESUMO
        // =====================================================

        resumoTitulo = new JLabel(
                "Resumo"
        );

        resumoTitulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        resumoTitulo.setAlignmentX(
                LEFT_ALIGNMENT
        );

        conteudo.add(resumoTitulo);

        conteudo.add(
                Box.createVerticalStrut(10)
        );

        resumo = new JPanel(
                new GridLayout(1, 4, 10, 0)
        );

        resumo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        80
                )
        );

        resumo.setAlignmentX(
                LEFT_ALIGNMENT
        );

        resumo.add(
                criarResumo("3", "Total")
        );

        resumo.add(
                criarResumo("1", "Confirmadas")
        );

        resumo.add(
                criarResumo("1", "Agendadas")
        );

        resumo.add(
                criarResumo("1", "Canceladas")
        );

        conteudo.add(resumo);

        principal.add(
                conteudo,
                BorderLayout.CENTER
        );

        setContentPane(principal);

        // =====================================================
        // AÇÕES
        // =====================================================

        agendar.addActionListener(
                e -> abrirAgendamento()
        );

        cardAgendar.addActionListener(
                e -> abrirAgendamento()
        );

        novaConsulta.addActionListener(
                e -> abrirAgendamento()
        );

        consultas.addActionListener(
                e -> abrirConsultas()
        );

        cardConsultas.addActionListener(
                e -> abrirConsultas()
        );

        perfil.addActionListener(
                e -> abrirPerfil()
        );

        inicio.addActionListener(
                e -> {
                    // Já está na tela principal
                }
        );

        sair.addActionListener(e -> {

            dispose();

            new TelaLoginManual().setVisible(true);
        });
    }

    // =========================================================
    // ATUALIZAR TODAS AS CORES
    // =========================================================

    public void atualizarCores() {

        Color principalTema =
                TemaSistema.getCorPrincipal();

        Color escura =
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

        // =====================================================
        // FUNDOS
        // =====================================================

        principal.setBackground(fundo);
        topo.setBackground(painel);
        menu.setBackground(principalTema);
        conteudo.setBackground(fundo);
        acoes.setBackground(fundo);
        consulta.setBackground(painel);
        resumo.setBackground(fundo);

        // =====================================================
        // BORDA DO TOPO
        // =====================================================

        topo.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        escuro
                                ? new Color(80, 88, 98)
                                : new Color(220, 225, 230)
                )
        );

        // =====================================================
        // TOPO
        // =====================================================

        site.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        subtitulo.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        cadeado.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        // =====================================================
        // MENU
        // =====================================================

        logo.setForeground(Color.WHITE);
        logo2.setForeground(Color.WHITE);

        iniciais.setBackground(
                Color.WHITE
        );

        iniciais.setForeground(
                escura
        );

        iniciais.setBorder(
                BorderFactory.createLineBorder(
                        Color.WHITE
                )
        );

        nome.setForeground(
                Color.WHITE
        );

        email.setForeground(
                new Color(225, 240, 245)
        );

        atualizarBotaoMenu(inicio);
        atualizarBotaoMenu(agendar);
        atualizarBotaoMenu(consultas);
        atualizarBotaoMenu(perfil);
        atualizarBotaoMenu(sair);

        // =====================================================
        // CONTEÚDO
        // =====================================================

        data.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        saudacao.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        descricao.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        proxima.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        psicologa.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        especialidade.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        horario.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        confirmada.setForeground(
                escuro
                        ? new Color(100, 210, 140)
                        : new Color(45, 150, 90)
        );

        resumoTitulo.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        novaConsulta.setForeground(
                principalTema
        );

        novaConsulta.setBackground(
                fundo
        );

        iniciaisAna.setBackground(
                principalTema
        );

        iniciaisAna.setForeground(
                Color.WHITE
        );

        // =====================================================
        // CARDS
        // =====================================================

        atualizarCard(cardAgendar);
        atualizarCard(cardConsultas);

        // =====================================================
        // RESUMOS
        // =====================================================

        atualizarResumo(resumo);

        // =====================================================
        // ATUALIZA COMPONENTES
        // =====================================================

        principal.revalidate();
        principal.repaint();
    }

    // =========================================================
    // BOTÕES DO MENU
    // =========================================================

    private void atualizarBotaoMenu(
            JButton botao
    ) {

        botao.setBackground(
                TemaSistema.getCorPrincipal()
        );

        botao.setForeground(
                Color.WHITE
        );

        botao.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 10, 5, 5
                )
        );
    }

    // =========================================================
    // CARDS
    // =========================================================

    private void atualizarCard(
            JButton botao
    ) {

        Color painel =
                TemaSistema.getCorPainel();

        Color texto =
                TemaSistema.getCorTexto();

        boolean escuro =
                TemaSistema.getTemaAtual()
                        .equals("ESCURO");

        botao.setBackground(
                painel
        );

        botao.setForeground(
                texto
        );

        botao.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                escuro
                                        ? new Color(80, 88, 98)
                                        : new Color(225, 230, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 18, 15, 18
                        )
                )
        );

        for (
                java.awt.Component componente
                : botao.getComponents()
        ) {

            if (componente instanceof JLabel) {

                JLabel label =
                        (JLabel) componente;

                label.setForeground(
                        texto
                );
            }

            if (componente instanceof JPanel) {

                JPanel painelInterno =
                        (JPanel) componente;

                for (
                        java.awt.Component filho
                        : painelInterno.getComponents()
                ) {

                    if (filho instanceof JLabel) {

                        JLabel label =
                                (JLabel) filho;

                        if (label.getFont().isBold()) {

                            label.setForeground(
                                    texto
                            );

                        } else {

                            label.setForeground(
                                    escuro
                                            ? new Color(210, 215, 220)
                                            : new Color(100, 110, 120)
                            );
                        }
                    }
                }
            }
        }
    }

    // =========================================================
    // RESUMOS
    // =========================================================

    private void atualizarResumo(
            JPanel painel
    ) {

        boolean escuro =
                TemaSistema.getTemaAtual()
                        .equals("ESCURO");

        Color fundoPainel =
                TemaSistema.getCorPainel();

        Color principalTema =
                TemaSistema.getCorPrincipal();

        for (
                java.awt.Component componente
                : painel.getComponents()
        ) {

            if (componente instanceof JPanel) {

                JPanel card =
                        (JPanel) componente;

                card.setBackground(
                        fundoPainel
                );

                card.setBorder(
                        BorderFactory.createLineBorder(
                                escuro
                                        ? new Color(80, 88, 98)
                                        : new Color(225, 230, 235)
                        )
                );

                for (
                        java.awt.Component filho
                        : card.getComponents()
                ) {

                    if (filho instanceof JLabel) {

                        JLabel label =
                                (JLabel) filho;

                        if (label.getFont().isBold()) {

                            label.setForeground(
                                    principalTema
                            );

                        } else {

                            label.setForeground(
                                    escuro
                                            ? new Color(210, 215, 220)
                                            : new Color(100, 110, 120)
                            );
                        }
                    }
                }
            }
        }
    }

    // =========================================================
    // CRIAR BOTÃO DO MENU
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
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return botao;
    }

    // =========================================================
    // CRIAR CARD
    // =========================================================

    private JButton criarCard(
            String titulo,
            String descricao
    ) {

        JButton botao =
                new JButton();

        botao.setLayout(
                new BorderLayout()
        );

        botao.setFocusPainted(false);

        botao.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        botao.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        JLabel icone =
                new JLabel(
                        titulo.equals(
                                "Agendar consulta"
                        )
                                ? "📅"
                                : "📋"
                );

        icone.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        23
                )
        );

        JPanel textos =
                new JPanel();

        textos.setOpaque(false);

        textos.setLayout(
                new BoxLayout(
                        textos,
                        BoxLayout.Y_AXIS
                )
        );

        textos.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 12, 0, 0
                )
        );

        JLabel tituloLabel =
                new JLabel(titulo);

        tituloLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JLabel descricaoLabel =
                new JLabel(descricao);

        descricaoLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        11
                )
        );

        textos.add(tituloLabel);

        textos.add(
                Box.createVerticalStrut(5)
        );

        textos.add(descricaoLabel);

        botao.add(
                icone,
                BorderLayout.WEST
        );

        botao.add(
                textos,
                BorderLayout.CENTER
        );

        return botao;
    }

    // =========================================================
    // CRIAR RESUMO
    // =========================================================

    private JPanel criarResumo(
            String numero,
            String texto
    ) {

        JPanel painel =
                new JPanel();

        painel.setLayout(
                new BoxLayout(
                        painel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel numeroLabel =
                new JLabel(
                        numero,
                        SwingConstants.CENTER
                );

        numeroLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        numeroLabel.setAlignmentX(
                CENTER_ALIGNMENT
        );

        JLabel textoLabel =
                new JLabel(
                        texto,
                        SwingConstants.CENTER
                );

        textoLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        11
                )
        );

        textoLabel.setAlignmentX(
                CENTER_ALIGNMENT
        );

        painel.add(
                Box.createVerticalGlue()
        );

        painel.add(numeroLabel);

        painel.add(
                Box.createVerticalStrut(3)
        );

        painel.add(textoLabel);

        painel.add(
                Box.createVerticalGlue()
        );

        return painel;
    }

    // =========================================================
    // ABRIR AGENDAMENTO
    // =========================================================

    private void abrirAgendamento() {

        dispose();

        try {

            new TelaAgendamento()
                    .setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "A TelaAgendamento ainda não foi criada."
            );
        }
    }

    // =========================================================
    // ABRIR CONSULTAS
    // =========================================================

    private void abrirConsultas() {

        dispose();

        try {

            new TelaConsultas()
                    .setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "A TelaConsultas ainda não foi criada."
            );
        }
    }

    // =========================================================
    // ABRIR PERFIL
    // =========================================================

    private void abrirPerfil() {

        dispose();

        try {

            new TelaPerfil()
                    .setVisible(true);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "A TelaPerfil ainda não foi criada."
            );
        }
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args
    ) {

        java.awt.EventQueue.invokeLater(
                () -> {

                    new TelaPrincipal()
                            .setVisible(true);
                }
        );
    }
}