package org.sufiAzarquiel.FirstFileManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window test");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new MainWindow().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    private JPanel contentPane;
    private JTextField textFieldName;
    private JPasswordField passwordField;
    private JButton buttonClear;
    private JLabel lblName;
    private JLabel lblPassword;

    public MainWindow() {
    buttonClear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldName.setText("");
            passwordField.setText("");
            }
        });
    }
}
