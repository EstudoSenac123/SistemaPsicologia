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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class TelaLoginManual extends JFrame {

    private final Color FUNDO = new Color(248, 250, 252);
    private final Color TEXTO = new Color(35, 55, 70);
    private final Color CINZA = new Color(105, 115, 125);
    private final Color BRANCO = Color.WHITE;

    private JTextField campoEmail;
    private JPasswordField campoSenha;

    // Componentes que precisam mudar de cor
    private JPanel principal;
    private JPanel cabecalho;
    private JPanel tituloHeader;
    private JPanel painelDireitaHeader;
    private JPanel centro;
    private JPanel informacoes;
    private JPanel navegacao;
    private JPanel areaLogin;
    private JPanel ladoEsquerdo;
    private JPanel ladoDireito;
    private JPanel criarConta;

    private JLabel tituloHeaderTexto;
    private JLabel subtituloHeader;
    private JLabel site;
    private JLabel tituloInterfaces;
    private JLabel descricao;
    private JLabel logo;
    private JLabel logo2;
    private JLabel tituloSistema;
    private JLabel textoSistema;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JLabel tituloLogin;
    private JLabel textoLogin;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JLabel pergunta;

    private JButton botaoTema;
    private JButton botaoLogin;
    private JButton botaoCadastro;
    private JButton botaoPrincipal;
    private JButton botaoAgendamento;
    private JButton botaoConsultas;
    private JButton botaoPerfil;
    private JButton botaoConfirmacao;
    private JButton entrar;
    private JButton criar;

    public TelaLoginManual() {

        setTitle("Sistema de Agendamento Psicológico");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        criarTela();

        atualizarCores();
    }

    private void criarTela() {

        principal = new JPanel(new BorderLayout());
        setContentPane(principal);

        // =========================================================
        // CABEÇALHO
        // =========================================================

        cabecalho = new JPanel(new BorderLayout());
        cabecalho.setPreferredSize(new Dimension(1000, 65));

        cabecalho.setBorder(
                BorderFactory.createMatteBorder(
                        0, 0, 1, 0,
                        new Color(225, 230, 235)
                )
        );

        tituloHeader = new JPanel();

        tituloHeader.setLayout(
                new BoxLayout(
                        tituloHeader,
                        BoxLayout.Y_AXIS
                )
        );

        tituloHeader.setBorder(
                new EmptyBorder(9, 25, 5, 0)
        );

        tituloHeaderTexto = new JLabel(
                "Agendamento Psicológico"
        );

        tituloHeaderTexto.setFont(
                new Font("Arial", Font.BOLD, 19)
        );

        subtituloHeader = new JLabel(
                "Projeto UX/UI - Protótipo Acadêmico"
        );

        subtituloHeader.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        tituloHeader.add(tituloHeaderTexto);
        tituloHeader.add(subtituloHeader);

        cabecalho.add(
                tituloHeader,
                BorderLayout.WEST
        );

        // =========================================================
        // PARTE DIREITA DO CABEÇALHO
        // =========================================================

        painelDireitaHeader = new JPanel();

        painelDireitaHeader.setLayout(
                new BoxLayout(
                        painelDireitaHeader,
                        BoxLayout.X_AXIS
                )
        );

        botaoTema = new JButton("🎨 Tema");

        botaoTema.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        botaoTema.setFocusPainted(false);

        botaoTema.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 215, 220)
                        ),
                        BorderFactory.createEmptyBorder(
                                7, 12, 7, 12
                        )
                )
        );

        painelDireitaHeader.add(botaoTema);

        painelDireitaHeader.add(
                Box.createHorizontalStrut(15)
        );

        site = new JLabel(
                "agendamentopsicologico.com.br"
        );

        site.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        painelDireitaHeader.add(site);

        painelDireitaHeader.add(
                Box.createHorizontalStrut(25)
        );

        cabecalho.add(
                painelDireitaHeader,
                BorderLayout.EAST
        );

        principal.add(
                cabecalho,
                BorderLayout.NORTH
        );

        // =========================================================
        // ÁREA CENTRAL
        // =========================================================

        centro = new JPanel(
                new BorderLayout()
        );

        informacoes = new JPanel();

        informacoes.setLayout(
                new BoxLayout(
                        informacoes,
                        BoxLayout.Y_AXIS
                )
        );

        informacoes.setBorder(
                new EmptyBorder(
                        18, 30, 12, 30
                )
        );

        tituloInterfaces = new JLabel(
                "Interfaces Finais"
        );

        tituloInterfaces.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        tituloInterfaces.setAlignmentX(
                LEFT_ALIGNMENT
        );

        descricao = new JLabel(
                "Protótipo interativo de alta fidelidade. "
                + "Navegue entre as telas pelos botões abaixo "
                + "ou use o sistema."
        );

        descricao.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        descricao.setAlignmentX(
                LEFT_ALIGNMENT
        );

        informacoes.add(tituloInterfaces);

        informacoes.add(
                Box.createVerticalStrut(4)
        );

        informacoes.add(descricao);

        informacoes.add(
                Box.createVerticalStrut(12)
        );

        // =========================================================
        // BOTÕES DE NAVEGAÇÃO
        // =========================================================

        navegacao = new JPanel(
                new GridLayout(1, 7, 5, 0)
        );

        botaoLogin =
                criarBotaoNavegacao(
                        "1. Login",
                        true
                );

        botaoCadastro =
                criarBotaoNavegacao(
                        "2. Cadastro",
                        false
                );

        botaoPrincipal =
                criarBotaoNavegacao(
                        "3. Principal",
                        false
                );

        botaoAgendamento =
                criarBotaoNavegacao(
                        "4. Agendamento",
                        false
                );

        botaoConsultas =
                criarBotaoNavegacao(
                        "5. Consultas",
                        false
                );

        botaoPerfil =
                criarBotaoNavegacao(
                        "6. Perfil",
                        false
                );

        botaoConfirmacao =
                criarBotaoNavegacao(
                        "7. Confirmação",
                        false
                );

        navegacao.add(botaoLogin);
        navegacao.add(botaoCadastro);
        navegacao.add(botaoPrincipal);
        navegacao.add(botaoAgendamento);
        navegacao.add(botaoConsultas);
        navegacao.add(botaoPerfil);
        navegacao.add(botaoConfirmacao);

        informacoes.add(navegacao);

        centro.add(
                informacoes,
                BorderLayout.NORTH
        );

        // =========================================================
        // ÁREA DE LOGIN
        // =========================================================

        areaLogin = new JPanel(
                new GridLayout(1, 2)
        );

        // =========================================================
        // LADO ESQUERDO
        // =========================================================

        ladoEsquerdo = new JPanel();

        ladoEsquerdo.setLayout(
                new BoxLayout(
                        ladoEsquerdo,
                        BoxLayout.Y_AXIS
                )
        );

        ladoEsquerdo.setBorder(
                new EmptyBorder(
                        45, 50, 40, 50
                )
        );

        logo = new JLabel("Agendamento");

        logo.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        logo.setAlignmentX(
                LEFT_ALIGNMENT
        );

        logo2 = new JLabel("Psicológico");

        logo2.setFont(
                new Font("Arial", Font.PLAIN, 24)
        );

        logo2.setAlignmentX(
                LEFT_ALIGNMENT
        );

        ladoEsquerdo.add(logo);
        ladoEsquerdo.add(logo2);

        ladoEsquerdo.add(
                Box.createVerticalStrut(35)
        );

        tituloSistema = new JLabel(
                "<html><b>Sistema de Agendamento "
                + "Psicológico</b></html>"
        );

        tituloSistema.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        tituloSistema.setAlignmentX(
                LEFT_ALIGNMENT
        );

        ladoEsquerdo.add(tituloSistema);

        ladoEsquerdo.add(
                Box.createVerticalStrut(15)
        );

        textoSistema = new JLabel(
                "<html>Cuidar da sua saúde mental é "
                + "um ato de coragem.<br>"
                + "Estamos aqui para facilitar esse caminho."
                + "</html>"
        );

        textoSistema.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        textoSistema.setAlignmentX(
                LEFT_ALIGNMENT
        );

        ladoEsquerdo.add(textoSistema);

        ladoEsquerdo.add(
                Box.createVerticalStrut(35)
        );

        info1 = criarInformacao(
                "Agendamento simples e rápido"
        );

        info2 = criarInformacao(
                "Psicólogos qualificados"
        );

        info3 = criarInformacao(
                "Privacidade garantida"
        );

        ladoEsquerdo.add(info1);

        ladoEsquerdo.add(
                Box.createVerticalStrut(15)
        );

        ladoEsquerdo.add(info2);

        ladoEsquerdo.add(
                Box.createVerticalStrut(15)
        );

        ladoEsquerdo.add(info3);

        areaLogin.add(ladoEsquerdo);

        // =========================================================
        // LADO DIREITO
        // =========================================================

        ladoDireito = new JPanel();

        ladoDireito.setLayout(
                new BoxLayout(
                        ladoDireito,
                        BoxLayout.Y_AXIS
                )
        );

        ladoDireito.setBorder(
                new EmptyBorder(
                        45, 55, 40, 55
                )
        );

        tituloLogin = new JLabel(
                "Bem-vindo de volta"
        );

        tituloLogin.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        tituloLogin.setAlignmentX(
                LEFT_ALIGNMENT
        );

        ladoDireito.add(tituloLogin);

        ladoDireito.add(
                Box.createVerticalStrut(8)
        );

        textoLogin = new JLabel(
                "Acesse sua conta para gerenciar suas consultas."
        );

        textoLogin.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        textoLogin.setAlignmentX(
                LEFT_ALIGNMENT
        );

        ladoDireito.add(textoLogin);

        ladoDireito.add(
                Box.createVerticalStrut(30)
        );

        labelEmail = criarLabel("E-mail");

        ladoDireito.add(labelEmail);

        ladoDireito.add(
                Box.createVerticalStrut(7)
        );

        campoEmail = new JTextField();

        configurarCampo(campoEmail);

        ladoDireito.add(campoEmail);

        ladoDireito.add(
                Box.createVerticalStrut(18)
        );

        labelSenha = criarLabel("Senha");

        ladoDireito.add(labelSenha);

        ladoDireito.add(
                Box.createVerticalStrut(7)
        );

        campoSenha = new JPasswordField();

        configurarCampo(campoSenha);

        ladoDireito.add(campoSenha);

        ladoDireito.add(
                Box.createVerticalStrut(28)
        );

        // =========================================================
        // BOTÃO ENTRAR
        // =========================================================

        entrar = new JButton("Entrar");

        entrar.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        entrar.setFocusPainted(false);

        entrar.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 20
                )
        );

        entrar.setAlignmentX(
                LEFT_ALIGNMENT
        );

        entrar.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        ladoDireito.add(entrar);

        ladoDireito.add(
                Box.createVerticalStrut(22)
        );

        // =========================================================
        // CRIAR CONTA
        // =========================================================

        criarConta = new JPanel(
                new GridLayout(1, 2)
        );

        criarConta.setAlignmentX(
                LEFT_ALIGNMENT
        );

        pergunta = new JLabel(
                "Não tem uma conta?"
        );

        pergunta.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        criar = new JButton(
                "Criar minha conta"
        );

        criar.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        criar.setBorder(null);
        criar.setFocusPainted(false);

        criarConta.add(pergunta);
        criarConta.add(criar);

        ladoDireito.add(criarConta);

        areaLogin.add(ladoDireito);

        centro.add(
                areaLogin,
                BorderLayout.CENTER
        );

        principal.add(
                centro,
                BorderLayout.CENTER
        );

        // =========================================================
        // BOTÃO TEMA
        // =========================================================

        botaoTema.addActionListener(e -> {

            String[] opcoes = {
                "Azul",
                "Verde",
                "Roxo",
                "Rosa",
                "Modo escuro"
            };

            String escolha =
                    (String) JOptionPane.showInputDialog(
                            this,
                            "Escolha o tema do sistema:",
                            "🎨 Tema",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoes,
                            "Azul"
                    );

            if (escolha == null) {
                return;
            }

            switch (escolha) {

                case "Azul":
                    TemaSistema.setTemaAtual("AZUL");
                    break;

                case "Verde":
                    TemaSistema.setTemaAtual("VERDE");
                    break;

                case "Roxo":
                    TemaSistema.setTemaAtual("ROXO");
                    break;

                case "Rosa":
                    TemaSistema.setTemaAtual("ROSA");
                    break;

                case "Modo escuro":
                    TemaSistema.setTemaAtual("ESCURO");
                    break;
            }

            // Atualiza as cores sem fechar a tela
            atualizarCores();
        });

        // =========================================================
        // CRIAR CONTA
        // =========================================================

        criar.addActionListener(e -> {

            dispose();

            new TelaCadastro().setVisible(true);
        });

        // =========================================================
        // CADASTRO
        // =========================================================

        botaoCadastro.addActionListener(e -> {

            dispose();

            new TelaCadastro().setVisible(true);
        });

        // =========================================================
        // ENTRAR
        // =========================================================

        entrar.addActionListener(e -> {

            String email =
                    campoEmail.getText().trim();

            String senha =
                    new String(
                            campoSenha.getPassword()
                    );

            if (email.isEmpty()
                    || senha.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Preencha o e-mail e a senha.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Login realizado com sucesso!",
                    "Login",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dispose();

            new TelaPrincipal().setVisible(true);
        });

        // =========================================================
        // PRINCIPAL
        // =========================================================

        botaoPrincipal.addActionListener(e -> {

            dispose();

            new TelaPrincipal().setVisible(true);
        });

        // =========================================================
        // AGENDAMENTO
        // =========================================================

        botaoAgendamento.addActionListener(e -> {

            dispose();

            new TelaAgendamento().setVisible(true);
        });

        // =========================================================
        // CONSULTAS
        // =========================================================

        botaoConsultas.addActionListener(e -> {

            dispose();

            new TelaConsultas().setVisible(true);
        });

        // =========================================================
        // PERFIL
        // =========================================================

        botaoPerfil.addActionListener(e -> {

            dispose();

            new TelaPerfil().setVisible(true);
        });

        // =========================================================
        // CONFIRMAÇÃO
        // =========================================================

        botaoConfirmacao.addActionListener(e -> {

            dispose();

            new TelaConfirmacao().setVisible(true);
        });
    }

    // =============================================================
    // ATUALIZA TODAS AS CORES DA TELA
    // =============================================================

    private void atualizarCores() {

        Color corPrincipal =
                TemaSistema.getCorPrincipal();

        Color corEscura =
                TemaSistema.getCorEscura();

        Color corFundo =
                TemaSistema.getCorFundo();

        Color corTexto =
                TemaSistema.getCorTexto();

        Color corPainel =
                TemaSistema.getCorPainel();

        // FUNDO GERAL
        principal.setBackground(corFundo);
        centro.setBackground(corFundo);
        informacoes.setBackground(corFundo);
        navegacao.setBackground(corFundo);

        // CABEÇALHO
        cabecalho.setBackground(corPainel);
        tituloHeader.setBackground(corPainel);
        painelDireitaHeader.setBackground(corPainel);

        tituloHeaderTexto.setForeground(corTexto);
        subtituloHeader.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(200, 205, 210)
                        : CINZA
        );

        site.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(200, 205, 210)
                        : CINZA
        );

        // BOTÃO TEMA
        botaoTema.setBackground(corPrincipal);
        botaoTema.setForeground(BRANCO);

        // INFORMAÇÕES
        tituloInterfaces.setForeground(corTexto);

        descricao.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(200, 205, 210)
                        : CINZA
        );

        // LADO ESQUERDO
        ladoEsquerdo.setBackground(corPrincipal);

        logo.setForeground(BRANCO);
        logo2.setForeground(BRANCO);
        tituloSistema.setForeground(BRANCO);
        textoSistema.setForeground(BRANCO);
        info1.setForeground(BRANCO);
        info2.setForeground(BRANCO);
        info3.setForeground(BRANCO);

        // LADO DIREITO
        ladoDireito.setBackground(corPainel);

        tituloLogin.setForeground(corTexto);

        textoLogin.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(200, 205, 210)
                        : CINZA
        );

        labelEmail.setForeground(corTexto);
        labelSenha.setForeground(corTexto);

        // CAMPOS
        if (TemaSistema.getTemaAtual().equals("ESCURO")) {

            campoEmail.setBackground(new Color(65, 70, 76));
            campoEmail.setForeground(BRANCO);

            campoSenha.setBackground(new Color(65, 70, 76));
            campoSenha.setForeground(BRANCO);

        } else {

            campoEmail.setBackground(BRANCO);
            campoEmail.setForeground(Color.BLACK);

            campoSenha.setBackground(BRANCO);
            campoSenha.setForeground(Color.BLACK);
        }

        // BOTÃO ENTRAR
        entrar.setBackground(corPrincipal);
        entrar.setForeground(BRANCO);

        // CRIAR CONTA
        criarConta.setBackground(corPainel);

        pergunta.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(200, 205, 210)
                        : CINZA
        );

        criar.setBackground(corPainel);
        criar.setForeground(corPrincipal);

        // BOTÕES DE NAVEGAÇÃO
        atualizarBotaoNavegacao(
                botaoLogin, true
        );

        atualizarBotaoNavegacao(
                botaoCadastro, false
        );

        atualizarBotaoNavegacao(
                botaoPrincipal, false
        );

        atualizarBotaoNavegacao(
                botaoAgendamento, false
        );

        atualizarBotaoNavegacao(
                botaoConsultas, false
        );

        atualizarBotaoNavegacao(
                botaoPerfil, false
        );

        atualizarBotaoNavegacao(
                botaoConfirmacao, false
        );

        principal.revalidate();
        principal.repaint();
    }

    // =============================================================
    // ATUALIZA BOTÕES DE NAVEGAÇÃO
    // =============================================================

    private void atualizarBotaoNavegacao(
            JButton botao,
            boolean selecionado) {

        Color corPrincipal =
                TemaSistema.getCorPrincipal();

        Color corPainel =
                TemaSistema.getCorPainel();

        Color corTexto =
                TemaSistema.getCorTexto();

        if (selecionado) {

            botao.setBackground(corPrincipal);
            botao.setForeground(BRANCO);

        } else {

            botao.setBackground(corPainel);
            botao.setForeground(corTexto);
        }
    }

    // =============================================================
    // INFORMAÇÕES
    // =============================================================

    private JLabel criarInformacao(
            String texto) {

        JLabel label =
                new JLabel(
                        "•  " + texto
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        label.setForeground(BRANCO);

        label.setAlignmentX(
                LEFT_ALIGNMENT
        );

        return label;
    }

    // =============================================================
    // LABEL
    // =============================================================

    private JLabel criarLabel(
            String texto) {

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

    // =============================================================
    // CAMPO
    // =============================================================

    private void configurarCampo(
            JTextField campo) {

        campo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        campo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        campo.setPreferredSize(
                new Dimension(
                        350,
                        38
                )
        );

        campo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 215, 220)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        campo.setAlignmentX(
                LEFT_ALIGNMENT
        );
    }

    // =============================================================
    // BOTÃO DE NAVEGAÇÃO
    // =============================================================

    private JButton criarBotaoNavegacao(
            String texto,
            boolean selecionado) {

        JButton botao =
                new JButton(texto);

        botao.setFont(
                new Font(
                        "Arial",
                        selecionado
                                ? Font.BOLD
                                : Font.PLAIN,
                        11
                )
        );

        botao.setFocusPainted(false);

        botao.setMargin(
                new Insets(
                        5, 5, 5, 5
                )
        );

        botao.setBorder(
                BorderFactory.createLineBorder(
                        new Color(215, 220, 225)
                )
        );

        return botao;
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    new TelaLoginManual()
                            .setVisible(true);

                }
        );
    }
}