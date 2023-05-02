package org.sufiAzarquiel.FirstFileManage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow extends JFrame implements ActionListener {

    private final JTextField textFieldName;

    /**
     * Create the frame.
     */
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textFieldName = new JTextField();
        textFieldName.setColumns(10);
        textFieldName.setBounds(44, 64, 288, 34);
        contentPane.add(textFieldName);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(44, 152, 288, 34);
        contentPane.add(passwordField);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(44, 21, 89, 32);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(44, 109, 89, 32);
        contentPane.add(lblPassword);

        JButton btnAccept = new JButton("Accept");
        btnAccept.addActionListener(this);
        btnAccept.setBounds(160, 216, 127, 34);
        contentPane.add(btnAccept);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> this.dispose());
        btnCancel.setBounds(297, 216, 127, 34);
        contentPane.add(btnCancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            MyFileManager myFileManager = new MyFileManager();
            myFileManager.writeToFile(textFieldName.getText());
            dispose();
    }
}