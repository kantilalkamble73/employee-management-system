package com.ems.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;

public class DeleteEmployeeFrame extends JFrame {

    private JTextField txtEmpId;

    public DeleteEmployeeFrame() {

        setTitle("Delete Employee");

        setSize(400, 250);

        setLayout(null);

        setLocationRelativeTo(null);

        JLabel lblId =
                new JLabel("Employee ID");

        lblId.setBounds(
                40,
                50,
                100,
                30);

        add(lblId);

        txtEmpId =
                new JTextField();

        txtEmpId.setBounds(
                150,
                50,
                150,
                30);

        add(txtEmpId);

        JButton btnDelete =
                new JButton("Delete");

        btnDelete.setBounds(
                130,
                120,
                120,
                35);

        add(btnDelete);

        btnDelete.addActionListener(e -> deleteEmployee());

        setVisible(true);
    }

    private void deleteEmployee() {

        try {

            int empId =
                    Integer.parseInt(
                            txtEmpId.getText());

            EmployeeDAO dao =
                    new EmployeeDAOImpl();

            boolean status =
                    dao.deleteEmployee(empId);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Deleted Successfully");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Not Found");
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Employee ID");
        }
    }
}