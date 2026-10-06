package com.mycompany.sistemapsicologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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

public class TelaConsultas extends JFrame {

    // =========================================================
    // COMPONENTES
    // =========================================================

    private JPanel principal;
    private JPanel topo;
    private JPanel menu;
    private JPanel conteudo;
    private JPanel listaConsultas;

    private JLabel tituloTopo;
    private JLabel subtitulo;
    private JLabel site;

    private JLabel logo;
    private JLabel logo2;

    private JLabel iniciais;
    private JLabel nomeUsuario;
    private JLabel emailUsuario;

    private JLabel tituloPagina;
    private JLabel descricao;

    private JButton inicio;
    private JButton agendar;
    private JButton consultas;
    private JButton perfil;
    private JButton sair;

    private JButton novaConsulta;

    // =========================================================
    // CONSTRUTOR
    // =========================================================

    public TelaConsultas() {

        setTitle("Minhas Consultas - Agendamento Psicológico");
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

        principal = new JPanel(
                new BorderLayout()
        );

        // =====================================================
        // TOPO
        // =====================================================

        topo = new JPanel(
                new BorderLayout()
        );

        topo.setPreferredSize(
                new Dimension(1000, 75)
        );

        JPanel textosTopo = new JPanel();

        textosTopo.setOpaque(false);

        textosTopo.setLayout(
                new BoxLayout(
                        textosTopo,
                        BoxLayout.Y_AXIS
                )
        );

        textosTopo.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 25, 8, 0
                )
        );

        tituloTopo = new JLabel(
                "Agendamento Psicológico"
        );

        tituloTopo.setFont(
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

        textosTopo.add(tituloTopo);

        textosTopo.add(
                Box.createVerticalStrut(3)
        );

        textosTopo.add(subtitulo);

        topo.add(
                textosTopo,
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

        JPanel usuario = new JPanel();

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

        nomeUsuario = new JLabel(
                "Maria Paciente"
        );

        nomeUsuario.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        nomeUsuario.setAlignmentX(
                LEFT_ALIGNMENT
        );

        emailUsuario = new JLabel(
                "maria@email.com"
        );

        emailUsuario.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        11
                )
        );

        emailUsuario.setAlignmentX(
                LEFT_ALIGNMENT
        );

        sair = criarBotaoMenu(
                "↩  Sair"
        );

        usuario.add(iniciais);

        usuario.add(
                Box.createVerticalStrut(8)
        );

        usuario.add(nomeUsuario);
        usuario.add(emailUsuario);

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
                        35, 40, 30, 40
                )
        );

        tituloPagina = new JLabel(
                "Minhas Consultas"
        );

        tituloPagina.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
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
                "Visualize suas consultas agendadas e seu histórico."
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
                Box.createVerticalStrut(25)
        );

        // =====================================================
        // LISTA DE CONSULTAS
        // =====================================================

        listaConsultas = new JPanel();

        listaConsultas.setLayout(
                new BoxLayout(
                        listaConsultas,
                        BoxLayout.Y_AXIS
                )
        );

        listaConsultas.setAlignmentX(
                LEFT_ALIGNMENT
        );

        listaConsultas.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 0, 0, 0
                )
        );

        // =====================================================
        // CONSULTA 1
        // =====================================================

        JPanel consulta1 =
                criarConsulta(
                        "Dra. Ana Carvalho",
                        "Terapia Cognitivo-Comportamental",
                        "22/09/2026",
                        "10:00",
                        "Confirmada"
                );

        listaConsultas.add(consulta1);

        listaConsultas.add(
                Box.createVerticalStrut(12)
        );

        // =====================================================
        // CONSULTA 2
        // =====================================================

        JPanel consulta2 =
                criarConsulta(
                        "Dra. Maria Souza",
                        "Psicologia Clínica",
                        "30/09/2026",
                        "14:00",
                        "Agendada"
                );

        listaConsultas.add(consulta2);

        conteudo.add(listaConsultas);

        conteudo.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // BOTÃO NOVA CONSULTA
        // =====================================================

        novaConsulta = new JButton(
                "+  Agendar nova consulta"
        );

        novaConsulta.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
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

        principal.add(
                conteudo,
                BorderLayout.CENTER
        );

        setContentPane(principal);

        // =====================================================
        // AÇÕES
        // =====================================================

        inicio.addActionListener(
                e -> abrirPrincipal()
        );

        agendar.addActionListener(
                e -> abrirAgendamento()
        );

        consultas.addActionListener(
                e -> {
                    // Já está na tela de consultas
                }
        );

        perfil.addActionListener(
                e -> abrirPerfil()
        );

        novaConsulta.addActionListener(
                e -> abrirAgendamento()
        );

        sair.addActionListener(
                e -> {

                    dispose();

                    new TelaLoginManual()
                            .setVisible(true);
                }
        );
    }

    // =========================================================
    // CRIAR CONSULTA
    // =========================================================

    private JPanel criarConsulta(
            String psicologo,
            String especialidade,
            String data,
            String horario,
            String status
    ) {

        JPanel card = new JPanel(
                new BorderLayout()
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        105
                )
        );

        card.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 18, 15, 18
                )
        );

        // =====================================================
        // INICIAIS
        // =====================================================

        JLabel iniciaisCard =
                new JLabel(
                        psicologo.equals(
                                "Dra. Ana Carvalho"
                        )
                                ? "AC"
                                : "MS",
                        SwingConstants.CENTER
                );

        iniciaisCard.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        iniciaisCard.setOpaque(true);

        iniciaisCard.setPreferredSize(
                new Dimension(50, 50)
        );

        card.add(
                iniciaisCard,
                BorderLayout.WEST
        );

        // =====================================================
        // DADOS
        // =====================================================

        JPanel dados = new JPanel();

        dados.setOpaque(false);

        dados.setLayout(
                new BoxLayout(
                        dados,
                        BoxLayout.Y_AXIS
                )
        );

        dados.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 15, 0, 0
                )
        );

        JLabel nomePsicologo =
                new JLabel(psicologo);

        nomePsicologo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        JLabel tipo =
                new JLabel(especialidade);

        tipo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        JLabel dataHorario =
                new JLabel(
                        data + "    |    " + horario
                );

        dataHorario.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        dados.add(nomePsicologo);

        dados.add(
                Box.createVerticalStrut(3)
        );

        dados.add(tipo);

        dados.add(
                Box.createVerticalStrut(8)
        );

        dados.add(dataHorario);

        card.add(
                dados,
                BorderLayout.CENTER
        );

        // =====================================================
        // STATUS
        // =====================================================

        JLabel statusLabel =
                new JLabel(status);

        statusLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        statusLabel.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 0, 0, 5
                )
        );

        card.add(
                statusLabel,
                BorderLayout.EAST
        );

        return card;
    }

    // =========================================================
    // ATUALIZAR CORES
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

        menu.setBackground(
                principalTema
        );

        conteudo.setBackground(
                fundo
        );

        listaConsultas.setBackground(
                fundo
        );

        // =====================================================
        // TOPO
        // =====================================================

        tituloTopo.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
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

        // =====================================================
        // MENU
        // =====================================================

        logo.setForeground(
                Color.WHITE
        );

        logo2.setForeground(
                Color.WHITE
        );

        iniciais.setBackground(
                Color.WHITE
        );

        iniciais.setForeground(
                escura
        );

        nomeUsuario.setForeground(
                Color.WHITE
        );

        emailUsuario.setForeground(
                new Color(225, 240, 245)
        );

        atualizarBotaoMenu(inicio);
        atualizarBotaoMenu(agendar);
        atualizarBotaoMenu(consultas);
        atualizarBotaoMenu(perfil);
        atualizarBotaoMenu(sair);

        // =====================================================
        // TÍTULOS
        // =====================================================

        tituloPagina.setForeground(
                escuro
                        ? Color.WHITE
                        : escura
        );

        descricao.setForeground(
                escuro
                        ? new Color(210, 215, 220)
                        : new Color(100, 110, 120)
        );

        // =====================================================
        // ATUALIZA CARDS
        // =====================================================

        atualizarCardsConsultas();

        // =====================================================
        // BOTÃO NOVA CONSULTA
        // =====================================================

        novaConsulta.setForeground(
                principalTema
        );

        novaConsulta.setBackground(
                fundo
        );

        // =====================================================
        // ATUALIZA TELA
        // =====================================================

        principal.revalidate();
        principal.repaint();
    }

    // =========================================================
    // ATUALIZAR CARDS
    // =========================================================

    private void atualizarCardsConsultas() {

        boolean escuro =
                TemaSistema.getTemaAtual()
                        .equals("ESCURO");

        Color painel =
                TemaSistema.getCorPainel();

        Color texto =
                TemaSistema.getCorTexto();

        Color principalTema =
                TemaSistema.getCorPrincipal();

        for (
                java.awt.Component componente
                : listaConsultas.getComponents()
        ) {

            if (componente instanceof JPanel) {

                JPanel card =
                        (JPanel) componente;

                card.setBackground(
                        painel
                );

                card.setBorder(
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
                        java.awt.Component filho
                        : card.getComponents()
                ) {

                    if (filho instanceof JLabel) {

                        JLabel label =
                                (JLabel) filho;

                        if (label.getText() == null) {
                            continue;
                        }

                        if (
                                label.getText().equals("Confirmada")
                                || label.getText().equals("Agendada")
                        ) {

                            label.setForeground(
                                    principalTema
                            );

                        } else {

                            if (
                                    label.getFont().isBold()
                            ) {

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

                        if (
                                label.getText().equals("AC")
                                || label.getText().equals("MS")
                        ) {

                            label.setBackground(
                                    principalTema
                            );

                            label.setForeground(
                                    Color.WHITE
                            );
                        }
                    }
                }
            }
        }
    }

    // =========================================================
    // BOTÃO MENU
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
    // CRIAR BOTÃO MENU
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
    // ABRIR PRINCIPAL
    // =========================================================

    private void abrirPrincipal() {

        dispose();

        new TelaPrincipal()
                .setVisible(true);
    }

    // =========================================================
    // ABRIR AGENDAMENTO
    // =========================================================

    private void abrirAgendamento() {

        dispose();

        new TelaAgendamento()
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
    // MAIN
    // =========================================================

    public static void main(
            String[] args
    ) {

        java.awt.EventQueue.invokeLater(
                () -> {

                    new TelaConsultas()
                            .setVisible(true);
                }
        );
    }
}