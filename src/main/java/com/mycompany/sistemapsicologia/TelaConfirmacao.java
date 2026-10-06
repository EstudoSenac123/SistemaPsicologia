package com.mycompany.sistemapsicologia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaConfirmacao extends JFrame {

    private JPanel principal;
    private JPanel topo;
    private JPanel conteudo;
    private JPanel card;
    private JPanel painelBotoes;

    private JLabel tituloTopo;
    private JLabel subtituloTopo;

    private JLabel titulo;
    private JLabel mensagem;
    private JLabel psicologo;
    private JLabel data;
    private JLabel horario;
    private JLabel status;

    private JButton voltar;
    private JButton minhasConsultas;
    private JButton inicio;

    public TelaConfirmacao() {

        setTitle("Confirmação - Agendamento Psicológico");
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

        JPanel esquerda = new JPanel(new GridLayout(2, 1));

        tituloTopo = new JLabel("Agendamento Psicológico");
        tituloTopo.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                20
        ));

        subtituloTopo = new JLabel(
                "Sistema de atendimento psicológico"
        );

        subtituloTopo.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                12
        ));

        esquerda.setOpaque(false);
        esquerda.add(tituloTopo);
        esquerda.add(subtituloTopo);

        JPanel painelEsquerda = new JPanel(
                new BorderLayout()
        );

        painelEsquerda.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 30, 10, 10
                )
        );

        painelEsquerda.setOpaque(false);
        painelEsquerda.add(
                esquerda,
                BorderLayout.CENTER
        );

        topo.add(
                painelEsquerda,
                BorderLayout.WEST
        );

        // =========================================================
        // CONTEÚDO
        // =========================================================

        conteudo = new JPanel(
                new BorderLayout()
        );

        conteudo.setBorder(
                BorderFactory.createEmptyBorder(
                        50, 100, 50, 100
                )
        );

        // =========================================================
        // CARD DE CONFIRMAÇÃO
        // =========================================================

        card = new JPanel(
                new BorderLayout()
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                TemaSistema.getCorPrincipal(),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                35, 50, 35, 50
                        )
                )
        );

        // =========================================================
        // TÍTULO
        // =========================================================

        JPanel painelTitulo = new JPanel(
                new GridLayout(2, 1)
        );

        titulo = new JLabel(
                "Agendamento confirmado!",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                28
        ));

        mensagem = new JLabel(
                "Sua consulta foi agendada com sucesso.",
                SwingConstants.CENTER
        );

        mensagem.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                15
        ));

        painelTitulo.setOpaque(false);

        painelTitulo.add(titulo);
        painelTitulo.add(mensagem);

        card.add(
                painelTitulo,
                BorderLayout.NORTH
        );

        // =========================================================
        // DADOS DA CONSULTA
        // =========================================================

        JPanel dados = new JPanel(
                new GridLayout(4, 1, 10, 10)
        );

        dados.setBorder(
                BorderFactory.createEmptyBorder(
                        35, 30, 25, 30
                )
        );

        dados.setOpaque(false);

        psicologo = new JLabel(
                "Psicólogo(a): Dra. Maria Souza"
        );

        data = new JLabel(
                "Data: Não informada"
        );

        horario = new JLabel(
                "Horário: Não informado"
        );

        status = new JLabel(
                "Status: AGENDADA",
                SwingConstants.CENTER
        );

        psicologo.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                16
        ));

        data.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                16
        ));

        horario.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                16
        ));

        status.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                16
        ));

        dados.add(psicologo);
        dados.add(data);
        dados.add(horario);
        dados.add(status);

        card.add(
                dados,
                BorderLayout.CENTER
        );

        // =========================================================
        // BOTÕES
        // =========================================================

        painelBotoes = new JPanel();

        painelBotoes.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 0, 0, 0
                )
        );

        voltar = new JButton(
                "Voltar"
        );

        minhasConsultas = new JButton(
                "Minhas consultas"
        );

        inicio = new JButton(
                "Página inicial"
        );

        configurarBotao(voltar);
        configurarBotao(minhasConsultas);
        configurarBotao(inicio);

        painelBotoes.add(voltar);
        painelBotoes.add(minhasConsultas);
        painelBotoes.add(inicio);

        card.add(
                painelBotoes,
                BorderLayout.SOUTH
        );

        conteudo.add(
                card,
                BorderLayout.CENTER
        );

        principal.add(
                topo,
                BorderLayout.NORTH
        );

        principal.add(
                conteudo,
                BorderLayout.CENTER
        );

        // =========================================================
        // AÇÕES
        // =========================================================

        voltar.addActionListener(e -> {

            new TelaAgendamento().setVisible(true);
            dispose();
        });

        minhasConsultas.addActionListener(e -> {

            new TelaConsultas().setVisible(true);
            dispose();
        });

        inicio.addActionListener(e -> {

            new TelaPrincipal().setVisible(true);
            dispose();
        });
    }

    // =============================================================
    // CONFIGURAR BOTÃO
    // =============================================================

    private void configurarBotao(JButton botao) {

        botao.setPreferredSize(
                new Dimension(170, 42)
        );

        botao.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                13
        ));

        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);

        botao.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }

    // =============================================================
    // ATUALIZAR TEMA
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
        // FUNDO
        // ---------------------------------------------------------

        principal.setBackground(fundo);
        conteudo.setBackground(fundo);

        // ---------------------------------------------------------
        // TOPO
        // ---------------------------------------------------------

        topo.setBackground(principalCor);

        tituloTopo.setForeground(Color.WHITE);
        subtituloTopo.setForeground(Color.WHITE);

        // ---------------------------------------------------------
        // CARD
        // ---------------------------------------------------------

        card.setBackground(painel);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                principalCor,
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                35, 50, 35, 50
                        )
                )
        );

        // ---------------------------------------------------------
        // TEXTOS
        // ---------------------------------------------------------

        titulo.setForeground(principalCor);
        mensagem.setForeground(texto);

        psicologo.setForeground(texto);
        data.setForeground(texto);
        horario.setForeground(texto);

        status.setForeground(principalCor);

        // ---------------------------------------------------------
        // PAINEL DOS BOTÕES
        // ---------------------------------------------------------

        painelBotoes.setBackground(painel);

        // ---------------------------------------------------------
        // BOTÕES
        // ---------------------------------------------------------

        voltar.setBackground(escura);
        minhasConsultas.setBackground(principalCor);
        inicio.setBackground(principalCor);

        voltar.setForeground(Color.WHITE);
        minhasConsultas.setForeground(Color.WHITE);
        inicio.setForeground(Color.WHITE);

        principal.revalidate();
        principal.repaint();
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaConfirmacao tela =
                    new TelaConfirmacao();

            tela.setVisible(true);
        });
    }
}