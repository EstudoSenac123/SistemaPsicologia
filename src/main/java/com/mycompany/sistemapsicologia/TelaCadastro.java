package com.mycompany.sistemapsicologia;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class TelaCadastro extends JFrame {

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmarSenha;

    // Componentes que precisam acompanhar o tema
    private JPanel principal;
    private JPanel esquerda;
    private JPanel direita;
    private JPanel painelLogin;

    private JLabel titulo;
    private JLabel descricao;
    private JLabel item1;
    private JLabel item2;
    private JLabel item3;
    private JLabel tituloCadastro;
    private JLabel subtitulo;
    private JLabel minimo;
    private JLabel textoLogin;

    private JButton botaoCadastrar;
    private JButton botaoLogin;

    public TelaCadastro() {

        setTitle("Cadastro - Agendamento Psicológico");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        montarTela();

        // Aplica o tema atual ao abrir a tela
        atualizarCores();
    }

    private void montarTela() {

        principal = new JPanel(new GridLayout(1, 2));

        // ==================================================
        // LADO ESQUERDO
        // ==================================================

        esquerda = new JPanel();

        esquerda.setLayout(
                new BoxLayout(esquerda, BoxLayout.Y_AXIS)
        );

        esquerda.setBorder(
                new EmptyBorder(90, 60, 50, 45)
        );

        titulo = new JLabel(
                "<html>Agendamento<br>Psicológico</html>"
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        esquerda.add(titulo);

        esquerda.add(
                Box.createVerticalStrut(30)
        );

        descricao = new JLabel(
                "<html>"
                + "Crie sua conta para acessar<br>"
                + "o sistema de agendamento."
                + "</html>"
        );

        descricao.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        esquerda.add(descricao);

        esquerda.add(
                Box.createVerticalStrut(45)
        );

        item1 = criarLabelEsquerda(
                "Cadastro rápido e simples"
        );

        esquerda.add(item1);

        esquerda.add(
                Box.createVerticalStrut(22)
        );

        item2 = criarLabelEsquerda(
                "Agende suas consultas"
        );

        esquerda.add(item2);

        esquerda.add(
                Box.createVerticalStrut(22)
        );

        item3 = criarLabelEsquerda(
                "Seus dados ficam protegidos"
        );

        esquerda.add(item3);

        // ==================================================
        // LADO DIREITO
        // ==================================================

        direita = new JPanel();

        direita.setLayout(
                new BoxLayout(direita, BoxLayout.Y_AXIS)
        );

        direita.setBorder(
                new EmptyBorder(35, 65, 25, 65)
        );

        tituloCadastro = new JLabel(
                "Criar minha conta"
        );

        tituloCadastro.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        tituloCadastro.setAlignmentX(
                JLabel.LEFT_ALIGNMENT
        );

        direita.add(tituloCadastro);

        direita.add(
                Box.createVerticalStrut(8)
        );

        subtitulo = new JLabel(
                "Preencha seus dados para se cadastrar."
        );

        subtitulo.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        subtitulo.setAlignmentX(
                JLabel.LEFT_ALIGNMENT
        );

        direita.add(subtitulo);

        direita.add(
                Box.createVerticalStrut(20)
        );

        // ==================================================
        // NOME COMPLETO
        // ==================================================

        direita.add(
                criarLabel("Nome completo")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoNome = new JTextField();

        configurarCampo(campoNome);

        direita.add(campoNome);

        direita.add(
                Box.createVerticalStrut(9)
        );

        // ==================================================
        // CPF
        // ==================================================

        direita.add(
                criarLabel("CPF")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoCpf = new JTextField();

        configurarCampo(campoCpf);

        direita.add(campoCpf);

        direita.add(
                Box.createVerticalStrut(9)
        );

        // ==================================================
        // TELEFONE
        // ==================================================

        direita.add(
                criarLabel("Telefone")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoTelefone = new JTextField();

        configurarCampo(campoTelefone);

        direita.add(campoTelefone);

        direita.add(
                Box.createVerticalStrut(9)
        );

        // ==================================================
        // E-MAIL
        // ==================================================

        direita.add(
                criarLabel("E-mail")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoEmail = new JTextField();

        configurarCampo(campoEmail);

        direita.add(campoEmail);

        direita.add(
                Box.createVerticalStrut(9)
        );

        // ==================================================
        // SENHA
        // ==================================================

        direita.add(
                criarLabel("Senha")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoSenha = new JPasswordField();

        configurarCampo(campoSenha);

        direita.add(campoSenha);

        minimo = new JLabel(
                "Mínimo 8 caracteres"
        );

        minimo.setFont(
                new Font("Arial", Font.PLAIN, 11)
        );

        minimo.setAlignmentX(
                JLabel.LEFT_ALIGNMENT
        );

        direita.add(minimo);

        direita.add(
                Box.createVerticalStrut(7)
        );

        // ==================================================
        // CONFIRMAR SENHA
        // ==================================================

        direita.add(
                criarLabel("Confirmar senha")
        );

        direita.add(
                Box.createVerticalStrut(4)
        );

        campoConfirmarSenha =
                new JPasswordField();

        configurarCampo(campoConfirmarSenha);

        direita.add(campoConfirmarSenha);

        direita.add(
                Box.createVerticalStrut(14)
        );

        // ==================================================
        // BOTÃO CADASTRAR
        // ==================================================

        botaoCadastrar =
                new JButton("Cadastrar");

        configurarBotaoPrincipal(
                botaoCadastrar
        );

        botaoCadastrar.addActionListener(
                e -> cadastrar()
        );

        direita.add(botaoCadastrar);

        direita.add(
                Box.createVerticalStrut(8)
        );

        // ==================================================
        // JÁ TENHO UMA CONTA
        // ==================================================

        painelLogin = new JPanel();

        painelLogin.setOpaque(false);

        painelLogin.setLayout(
                new BoxLayout(
                        painelLogin,
                        BoxLayout.X_AXIS
                )
        );

        painelLogin.setAlignmentX(
                JPanel.LEFT_ALIGNMENT
        );

        textoLogin = new JLabel(
                "Já tenho uma conta."
        );

        textoLogin.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        botaoLogin =
                new JButton("Fazer login");

        botaoLogin.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        botaoLogin.setBorderPainted(false);
        botaoLogin.setContentAreaFilled(false);
        botaoLogin.setFocusPainted(false);

        botaoLogin.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        botaoLogin.addActionListener(e -> {

            dispose();

            SwingUtilities.invokeLater(() -> {

                TelaLoginManual telaLogin =
                        new TelaLoginManual();

                telaLogin.setVisible(true);
            });
        });

        painelLogin.add(textoLogin);

        painelLogin.add(
                Box.createHorizontalStrut(4)
        );

        painelLogin.add(botaoLogin);

        direita.add(painelLogin);

        // ==================================================
        // MONTAR
        // ==================================================

        principal.add(esquerda);
        principal.add(direita);

        add(principal);
    }

    // ==================================================
    // ATUALIZAR CORES DO TEMA
    // ==================================================

    public void atualizarCores() {

        Color principalCor =
                TemaSistema.getCorPrincipal();

        Color corEscura =
                TemaSistema.getCorEscura();

        Color fundo =
                TemaSistema.getCorFundo();

        Color texto =
                TemaSistema.getCorTexto();

        Color painel =
                TemaSistema.getCorPainel();

        // Fundo geral
        principal.setBackground(fundo);

        direita.setBackground(painel);

        // Lado esquerdo
        esquerda.setBackground(principalCor);

        titulo.setForeground(Color.WHITE);
        descricao.setForeground(Color.WHITE);

        item1.setForeground(Color.WHITE);
        item2.setForeground(Color.WHITE);
        item3.setForeground(Color.WHITE);

        // Títulos do lado direito
        tituloCadastro.setForeground(texto);

        subtitulo.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? Color.WHITE
                        : new Color(100, 110, 120)
        );

        minimo.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(210, 215, 220)
                        : new Color(110, 120, 130)
        );

        textoLogin.setForeground(
                TemaSistema.getTemaAtual().equals("ESCURO")
                        ? new Color(220, 225, 230)
                        : new Color(90, 100, 110)
        );

        botaoLogin.setForeground(principalCor);

        // Botão principal
        botaoCadastrar.setBackground(principalCor);
        botaoCadastrar.setForeground(Color.WHITE);

        // Labels dos campos
        atualizarLabels(direita, texto);

        // Campos
        atualizarCampo(campoNome);
        atualizarCampo(campoCpf);
        atualizarCampo(campoTelefone);
        atualizarCampo(campoEmail);
        atualizarCampo(campoSenha);
        atualizarCampo(campoConfirmarSenha);

        repaint();
    }

    // ==================================================
    // ATUALIZAR LABELS
    // ==================================================

    private void atualizarLabels(
            JPanel painel,
            Color cor
    ) {

        for (java.awt.Component componente
                : painel.getComponents()) {

            if (componente instanceof JLabel) {

                JLabel label =
                        (JLabel) componente;

                if (label != tituloCadastro
                        && label != subtitulo
                        && label != minimo
                        && label != textoLogin) {

                    label.setForeground(cor);
                }
            }
        }
    }

    // ==================================================
    // ATUALIZAR CAMPOS
    // ==================================================

    private void atualizarCampo(
            JTextField campo
    ) {

        boolean escuro =
                TemaSistema.getTemaAtual()
                        .equals("ESCURO");

        campo.setBackground(
                escuro
                        ? new Color(55, 61, 68)
                        : Color.WHITE
        );

        campo.setForeground(
                escuro
                        ? Color.WHITE
                        : new Color(35, 55, 70)
        );

        campo.setCaretColor(
                TemaSistema.getCorPrincipal()
        );

        campo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                escuro
                                        ? new Color(90, 98, 108)
                                        : new Color(210, 215, 220)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );
    }

    // ==================================================
    // LABEL DO LADO ESQUERDO
    // ==================================================

    private JLabel criarLabelEsquerda(
            String texto
    ) {

        JLabel label = new JLabel(texto);

        label.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        label.setAlignmentX(
                JLabel.LEFT_ALIGNMENT
        );

        return label;
    }

    // ==================================================
    // LABEL DOS CAMPOS
    // ==================================================

    private JLabel criarLabel(
            String texto
    ) {

        JLabel label = new JLabel(texto);

        label.setFont(
                new Font("Arial", Font.BOLD, 13)
        );

        label.setAlignmentX(
                JLabel.LEFT_ALIGNMENT
        );

        return label;
    }

    // ==================================================
    // CONFIGURAR CAMPO
    // ==================================================

    private void configurarCampo(
            JTextField campo
    ) {

        campo.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        campo.setPreferredSize(
                new Dimension(350, 35)
        );

        campo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );

        campo.setAlignmentX(
                JTextField.LEFT_ALIGNMENT
        );
    }

    // ==================================================
    // CONFIGURAR BOTÃO
    // ==================================================

    private void configurarBotaoPrincipal(
            JButton botao
    ) {

        botao.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        botao.setFocusPainted(false);
        botao.setBorderPainted(false);

        botao.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        botao.setPreferredSize(
                new Dimension(350, 42)
        );

        botao.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        botao.setAlignmentX(
                JButton.LEFT_ALIGNMENT
        );
    }

    // ==================================================
    // CADASTRAR NO MYSQL
    // ==================================================

    private void cadastrar() {

        String nome =
                campoNome.getText().trim();

        String cpf =
                campoCpf.getText().trim();

        String telefone =
                campoTelefone.getText().trim();

        String email =
                campoEmail.getText().trim();

        String senha =
                new String(
                        campoSenha.getPassword()
                );

        String confirmarSenha =
                new String(
                        campoConfirmarSenha.getPassword()
                );

        // ==================================================
        // VALIDAÇÃO DOS CAMPOS
        // ==================================================

        if (nome.isEmpty()
                || cpf.isEmpty()
                || telefone.isEmpty()
                || email.isEmpty()
                || senha.isEmpty()
                || confirmarSenha.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ==================================================
        // VALIDAÇÃO DA SENHA
        // ==================================================

        if (senha.length() < 8) {

            JOptionPane.showMessageDialog(
                    this,
                    "A senha deve ter no mínimo 8 caracteres.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ==================================================
        // CONFIRMAÇÃO DA SENHA
        // ==================================================

        if (!senha.equals(confirmarSenha)) {

            JOptionPane.showMessageDialog(
                    this,
                    "As senhas não são iguais.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ==================================================
        // CONECTAR AO MYSQL
        // ==================================================

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

        // ==================================================
        // SALVAR PACIENTE
        // ==================================================

        String sql =
                "INSERT INTO paciente "
                + "(nome, cpf, telefone, email, senha) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement comando =
                banco.getConexao().prepareStatement(sql)) {

            comando.setString(1, nome);
            comando.setString(2, cpf);
            comando.setString(3, telefone);
            comando.setString(4, email);
            comando.setString(5, senha);

            comando.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Paciente cadastrado e salvo no MySQL!",
                    "Cadastro realizado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Limpa os campos depois do cadastro
            campoNome.setText("");
            campoCpf.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
            campoSenha.setText("");
            campoConfirmarSenha.setText("");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao salvar paciente no MySQL.\n\n"
                    + "Detalhes: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } finally {

            banco.desconectar();
        }
    }

    // ==================================================
    // INICIAR
    // ==================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaCadastro tela =
                    new TelaCadastro();

            tela.setVisible(true);
        });
    }
}