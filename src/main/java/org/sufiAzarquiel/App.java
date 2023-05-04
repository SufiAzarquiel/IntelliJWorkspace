package org.sufiAzarquiel;

import org.sufiAzarquiel.Agenda.AgendaWindow;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                AgendaWindow frame = new AgendaWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}