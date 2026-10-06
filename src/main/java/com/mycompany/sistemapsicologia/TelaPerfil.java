package com.mycompany.sistemapsicologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaPerfil extends JFrame {

    private JPanel principal;
    private JPanel topo;
    private JPanel menu;
    private JPanel conteudo;
    private JPanel cardPerfil;
    private JPanel painelBotoes;

    private JLabel logo;
    private JLabel titulo;
    private JLabel subtitulo;
    private JLabel usuarioNome;
    private JLabel usuarioEmail;

    private JLabel tituloPagina;
    private JLabel descricao;

    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelTelefone;
    private JLabel labelCpf;

    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JTextField campoCpf;

    private JButton inicio;
    private JButton consultas;
    private JButton agendamento;
    private JButton perfil;
    private JButton sair;

    private JButton editar;
    private JButton salvar;

    public TelaPerfil() {

        setTitle("Meu Perfil - Sistema de Agendamento Psicológico");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        montarTela();
        atualizarCores();
    }

    private void montarTela() {

        principal = new JPanel(new BorderLayout());
        setContentPane(principal);

        // =========================================================
        // TOPO
        // =========================================================

        topo = new JPanel(new BorderLayout());
        topo.setPreferredSize(new Dimension(1000, 80));

        JPanel painelLogo = new JPanel(new FlowLayout(
                FlowLayout.LEFT, 25, 15
        ));

        logo = new JLabel("PSICO");
        logo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        painelLogo.setOpaque(false);
        painelLogo.add(logo);

        JPanel painelTitulo = new JPanel();
        painelTitulo.setLayout(new GridLayout(2, 1));

        titulo = new JLabel("Agendamento Psicológico");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        subtitulo = new JLabel("Sistema de atendimento psicológico");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        painelTitulo.setOpaque(false);
        painelTitulo.add(titulo);
        painelTitulo.add(subtitulo);

        JPanel painelTopoCentro = new JPanel(new FlowLayout(
                FlowLayout.LEFT, 10, 15
        ));

        painelTopoCentro.setOpaque(false);
        painelTopoCentro.add(painelTitulo);

        JPanel painelUsuario = new JPanel(new GridLayout(2, 1));

        usuarioNome = new JLabel("Usuário");
        usuarioNome.setFont(new Font("Segoe UI", Font.BOLD, 14));

        usuarioEmail = new JLabel("usuario@email.com");
        usuarioEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        painelUsuario.setOpaque(false);
        painelUsuario.add(usuarioNome);
        painelUsuario.add(usuarioEmail);

        JPanel painelTopoDireita = new JPanel(new FlowLayout(
                FlowLayout.RIGHT, 25, 15
        ));

        painelTopoDireita.setOpaque(false);
        painelTopoDireita.add(painelUsuario);

        topo.add(painelLogo, BorderLayout.WEST);
        topo.add(painelTopoCentro, BorderLayout.CENTER);
        topo.add(painelTopoDireita, BorderLayout.EAST);

        // =========================================================
        // MENU LATERAL
        // =========================================================

        menu = new JPanel();
        menu.setPreferredSize(new Dimension(210, 620));
        menu.setLayout(new GridLayout(8, 1, 0, 8));
        menu.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));

        inicio = criarBotaoMenu("⌂  Início");
        agendamento = criarBotaoMenu("📅  Agendamento");
        consultas = criarBotaoMenu("📋  Minhas consultas");
        perfil = criarBotaoMenu("👤  Meu perfil");
        sair = criarBotaoMenu("↩  Sair");

        menu.add(inicio);
        menu.add(agendamento);
        menu.add(consultas);
        menu.add(perfil);

        JPanel espaco = new JPanel();
        espaco.setOpaque(false);

        menu.add(espaco);

        JPanel painelSair = new JPanel(new BorderLayout());
        painelSair.setOpaque(false);
        painelSair.add(sair, BorderLayout.SOUTH);

        menu.add(painelSair);

        // =========================================================
        // CONTEÚDO
        // =========================================================

        conteudo = new JPanel(new BorderLayout());
        conteudo.setBorder(BorderFactory.createEmptyBorder(
                35, 40, 35, 40
        ));

        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(new GridLayout(2, 1));

        tituloPagina = new JLabel("Meu Perfil");
        tituloPagina.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                28
        ));

        descricao = new JLabel(
                "Visualize e edite seus dados pessoais."
        );

        descricao.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                14
        ));

        cabecalho.setOpaque(false);
        cabecalho.add(tituloPagina);
        cabecalho.add(descricao);

        conteudo.add(cabecalho, BorderLayout.NORTH);

        // =========================================================
        // CARD DO PERFIL
        // =========================================================

        cardPerfil = new JPanel(new BorderLayout());
        cardPerfil.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        TemaSistema.getCorPrincipal(),
                        1
                ),
                BorderFactory.createEmptyBorder(
                        25, 30, 25, 30
                )
        ));

        JPanel dados = new JPanel(new GridLayout(
                4, 2, 15, 18
        ));

        dados.setOpaque(false);

        labelNome = new JLabel("Nome:");
        labelEmail = new JLabel("E-mail:");
        labelTelefone = new JLabel("Telefone:");
        labelCpf = new JLabel("CPF:");

        labelNome.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        labelEmail.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        labelTelefone.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        labelCpf.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        campoNome = new JTextField("Nome do paciente");
        campoEmail = new JTextField("usuario@email.com");
        campoTelefone = new JTextField("(00) 00000-0000");
        campoCpf = new JTextField("000.000.000-00");

        dados.add(labelNome);
        dados.add(campoNome);

        dados.add(labelEmail);
        dados.add(campoEmail);

        dados.add(labelTelefone);
        dados.add(campoTelefone);

        dados.add(labelCpf);
        dados.add(campoCpf);

        cardPerfil.add(dados, BorderLayout.CENTER);

        // =========================================================
        // BOTÕES
        // =========================================================

        painelBotoes = new JPanel(new FlowLayout(
                FlowLayout.RIGHT,
                10,
                15
        ));

        painelBotoes.setOpaque(false);

        editar = new JButton("Editar perfil");
        salvar = new JButton("Salvar alterações");

        configurarBotao(editar);
        configurarBotao(salvar);

        painelBotoes.add(editar);
        painelBotoes.add(salvar);

        cardPerfil.add(painelBotoes, BorderLayout.SOUTH);

        conteudo.add(cardPerfil, BorderLayout.CENTER);

        // =========================================================
        // ADICIONA NA JANELA
        // =========================================================

        principal.add(topo, BorderLayout.NORTH);
        principal.add(menu, BorderLayout.WEST);
        principal.add(conteudo, BorderLayout.CENTER);

        // =========================================================
        // AÇÕES DO MENU
        // =========================================================

        inicio.addActionListener(e -> {
            new TelaPrincipal().setVisible(true);
            dispose();
        });

        agendamento.addActionListener(e -> {
            new TelaAgendamento().setVisible(true);
            dispose();
        });

        consultas.addActionListener(e -> {
            new TelaConsultas().setVisible(true);
            dispose();
        });

        perfil.addActionListener(e -> {
            // Já está na tela de perfil
        });

        sair.addActionListener(e -> {
            new TelaLoginManual().setVisible(true);
            dispose();
        });

        // =========================================================
        // AÇÕES DOS BOTÕES DO PERFIL
        // =========================================================

        editar.addActionListener(e -> {

            campoNome.setEditable(true);
            campoEmail.setEditable(true);
            campoTelefone.setEditable(true);
            campoCpf.setEditable(true);

            JOptionPane.showMessageDialog(
                    this,
                    "Agora você pode editar seus dados."
            );
        });

        salvar.addActionListener(e -> {

            if (campoNome.getText().trim().isEmpty()
                    || campoEmail.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha pelo menos o nome e o e-mail."
                );

                return;
            }

            usuarioNome.setText(campoNome.getText());
            usuarioEmail.setText(campoEmail.getText());

            JOptionPane.showMessageDialog(
                    this,
                    "Alterações salvas com sucesso!"
            );
        });
    }

    // =============================================================
    // CRIAR BOTÃO DO MENU
    // =============================================================

    private JButton criarBotaoMenu(String texto) {

        JButton botao = new JButton(texto);

        botao.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                14
        ));

        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);

        botao.setCursor(new Cursor(
                Cursor.HAND_CURSOR
        ));

        botao.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        botao.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 15, 10, 10
                )
        );

        botao.setBackground(
                TemaSistema.getCorPainel()
        );

        botao.setForeground(
                TemaSistema.getCorTexto()
        );

        return botao;
    }

    // =============================================================
    // CONFIGURAR BOTÕES
    // =============================================================

    private void configurarBotao(JButton botao) {

        botao.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                13
        ));

        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);

        botao.setCursor(new Cursor(
                Cursor.HAND_CURSOR
        ));

        botao.setPreferredSize(
                new Dimension(160, 40)
        );
    }

    // =============================================================
    // ATUALIZAR CORES DO TEMA
    // =============================================================

    public void atualizarCores() {

        Color principalCor =
                TemaSistema.getCorPrincipal();

        Color escura =
                TemaSistema.getCorEscura();

        Color fundo =
                TemaSistema.getCorFundo();

        Color texto =
                TemaSistema.getCorTexto();

        Color painel =
                TemaSistema.getCorPainel();

        // ---------------------------------------------------------
        // FUNDO PRINCIPAL
        // ---------------------------------------------------------

        principal.setBackground(fundo);
        conteudo.setBackground(fundo);

        // ---------------------------------------------------------
        // TOPO
        // ---------------------------------------------------------

        topo.setBackground(principalCor);

        logo.setForeground(Color.WHITE);
        titulo.setForeground(Color.WHITE);
        subtitulo.setForeground(Color.WHITE);

        usuarioNome.setForeground(Color.WHITE);
        usuarioEmail.setForeground(Color.WHITE);

        // ---------------------------------------------------------
        // MENU
        // ---------------------------------------------------------

        menu.setBackground(painel);

        inicio.setBackground(painel);
        agendamento.setBackground(painel);
        consultas.setBackground(painel);
        perfil.setBackground(principalCor);
        sair.setBackground(painel);

        inicio.setForeground(texto);
        agendamento.setForeground(texto);
        consultas.setForeground(texto);
        perfil.setForeground(Color.WHITE);
        sair.setForeground(texto);

        // ---------------------------------------------------------
        // TÍTULOS
        // ---------------------------------------------------------

        tituloPagina.setForeground(texto);
        descricao.setForeground(
                TemaSistema.getCorTexto()
        );

        // ---------------------------------------------------------
        // CARD
        // ---------------------------------------------------------

        cardPerfil.setBackground(painel);

        cardPerfil.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                principalCor,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                25, 30, 25, 30
                        )
                )
        );

        // ---------------------------------------------------------
        // LABELS
        // ---------------------------------------------------------

        labelNome.setForeground(texto);
        labelEmail.setForeground(texto);
        labelTelefone.setForeground(texto);
        labelCpf.setForeground(texto);

        // ---------------------------------------------------------
        // CAMPOS
        // ---------------------------------------------------------

        campoNome.setBackground(fundo);
        campoEmail.setBackground(fundo);
        campoTelefone.setBackground(fundo);
        campoCpf.setBackground(fundo);

        campoNome.setForeground(texto);
        campoEmail.setForeground(texto);
        campoTelefone.setForeground(texto);
        campoCpf.setForeground(texto);

        campoNome.setCaretColor(texto);
        campoEmail.setCaretColor(texto);
        campoTelefone.setCaretColor(texto);
        campoCpf.setCaretColor(texto);

        // ---------------------------------------------------------
        // BOTÕES
        // ---------------------------------------------------------

        editar.setBackground(escura);
        salvar.setBackground(principalCor);

        editar.setForeground(Color.WHITE);
        salvar.setForeground(Color.WHITE);

        // ---------------------------------------------------------
        // REVALIDAR E REDESENHAR
        // ---------------------------------------------------------

        principal.revalidate();
        principal.repaint();
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaPerfil tela = new TelaPerfil();

            tela.setVisible(true);
        });
    }
}