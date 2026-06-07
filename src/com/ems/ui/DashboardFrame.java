package com.ems.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Dashboard");

        setSize(600, 400);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add Employee Button
        JButton btnAdd = new JButton("Add Employee");

        btnAdd.setBounds(
                50,
                50,
                180,
                40);

        btnAdd.addActionListener(e -> {

            new AddEmployeeFrame();
        });

        add(btnAdd);

        // View Employee Button
        JButton btnView = new JButton("View Employee");

        btnView.setBounds(
                300,
                50,
                180,
                40);

        btnView.addActionListener(e -> {

            new ViewEmployeeFrame();
        });

        add(btnView);
        JButton btnSearch = new JButton("Search Employee");

        btnSearch.setBounds(
                50,
                130,
                180,
                40);

        btnSearch.addActionListener(e -> {

            new SearchEmployeeFrame();
        });

        add(btnSearch);
        
        JButton btnUpdate = new JButton("Update Employee");

        btnUpdate.setBounds(
                300,
                130,
                180,
                40);

        btnUpdate.addActionListener(e -> {

            new UpdateEmployeeFrame();
        });

        add(btnUpdate);
        
        JButton btnDelete = new JButton("Delete Employee");

        btnDelete.setBounds(
                175,
                210,
                180,
                40);

        btnDelete.addActionListener(e -> {

            new DeleteEmployeeFrame();
        });

        add(btnDelete);

        setVisible(true);
    }
}