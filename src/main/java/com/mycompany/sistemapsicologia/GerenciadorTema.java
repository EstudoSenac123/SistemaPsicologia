package com.mycompany.sistemapsicologia;

import java.awt.Window;
import javax.swing.SwingUtilities;

public class GerenciadorTema {

    public static void atualizarTodasAsTelas() {

        for (Window janela : Window.getWindows()) {

            if (janela.isDisplayable()) {

                SwingUtilities.updateComponentTreeUI(janela);

                janela.repaint();
            }
        }
    }
}