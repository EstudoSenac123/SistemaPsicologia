package com.mycompany.sistemapsicologia;

import java.awt.Color;

public class TemaSistema {

    // =========================
    // TEMA AZUL
    // =========================

    public static final Color AZUL = new Color(42, 153, 181);
    public static final Color AZUL_ESCURO = new Color(32, 132, 159);

    // =========================
    // TEMA VERDE
    // =========================

    public static final Color VERDE = new Color(46, 160, 100);
    public static final Color VERDE_ESCURO = new Color(35, 130, 80);

    // =========================
    // TEMA ROXO
    // =========================

    public static final Color ROXO = new Color(126, 87, 194);
    public static final Color ROXO_ESCURO = new Color(95, 63, 160);

    // =========================
    // TEMA ROSA
    // =========================

    public static final Color ROSA = new Color(219, 91, 132);
    public static final Color ROSA_ESCURO = new Color(180, 65, 105);

    // =========================
    // MODO ESCURO
    // =========================

    public static final Color ESCURO = new Color(35, 40, 45);
    public static final Color ESCURO_2 = new Color(48, 54, 61);

    // =========================
    // CORES GERAIS
    // =========================

    public static final Color FUNDO = new Color(248, 250, 252);
    public static final Color BRANCO = Color.WHITE;
    public static final Color TEXTO = new Color(35, 55, 70);

    // =========================
    // TEMA ATUAL
    // =========================

    private static String temaAtual = "AZUL";

    public static String getTemaAtual() {
        return temaAtual;
    }

    public static void setTemaAtual(String tema) {
        temaAtual = tema;
    }

    // =========================
    // COR PRINCIPAL
    // =========================

    public static Color getCorPrincipal() {

        switch (temaAtual) {

            case "VERDE":
                return VERDE;

            case "ROXO":
                return ROXO;

            case "ROSA":
                return ROSA;

            case "ESCURO":
                return ESCURO;

            default:
                return AZUL;
        }
    }

    // =========================
    // COR ESCURA
    // =========================

    public static Color getCorEscura() {

        switch (temaAtual) {

            case "VERDE":
                return VERDE_ESCURO;

            case "ROXO":
                return ROXO_ESCURO;

            case "ROSA":
                return ROSA_ESCURO;

            case "ESCURO":
                return ESCURO_2;

            default:
                return AZUL_ESCURO;
        }
    }

    // =========================
    // COR DO FUNDO
    // =========================

    public static Color getCorFundo() {

        if (temaAtual.equals("ESCURO")) {
            return ESCURO;
        }

        return FUNDO;
    }

    // =========================
    // COR DO TEXTO
    // =========================

    public static Color getCorTexto() {

        if (temaAtual.equals("ESCURO")) {
            return BRANCO;
        }

        return TEXTO;
    }

    // =========================
    // COR DOS PAINÉIS
    // =========================

    public static Color getCorPainel() {

        if (temaAtual.equals("ESCURO")) {
            return ESCURO_2;
        }

        return BRANCO;
    }
}