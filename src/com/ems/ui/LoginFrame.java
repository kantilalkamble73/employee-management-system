package com.ems.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    private JLabel lblTitle;
    private JLabel lblUsername;
    private JLabel lblPassword;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnLogin;

    public LoginFrame() {

        setTitle("Employee Management System");

        setSize(500, 350);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitle =
                new JLabel("Employee Management System");

        lblTitle.setBounds(70, 20, 350, 40);

        lblTitle.setFont(
                new Font("Arial",
                        Font.BOLD,
                        22));

        add(lblTitle);

        lblUsername =
                new JLabel("Username");

        lblUsername.setBounds(
                70,
                90,
                100,
                30);

        add(lblUsername);

        txtUsername =
                new JTextField();

        txtUsername.setBounds(
                180,
                90,
                180,
                30);

        add(txtUsername);

        lblPassword =
                new JLabel("Password");

        lblPassword.setBounds(
                70,
                140,
                100,
                30);

        add(lblPassword);

        txtPassword =
                new JPasswordField();

        txtPassword.setBounds(
                180,
                140,
                180,
                30);

        add(txtPassword);

        btnLogin =
                new JButton("Login");

        btnLogin.setBounds(
                180,
                200,
                120,
                35);

        add(btnLogin);

        btnLogin.addActionListener(e -> {

            String username =
                    txtUsername.getText();

            String password =
                    String.valueOf(
                            txtPassword.getPassword());

            if(username.equals("admin")
                    && password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful");

                dispose();

                new DashboardFrame();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password");
            }
        });

        setVisible(true);
    }
}