package com.ems.ui;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class UpdateEmployeeFrame extends JFrame {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtDepartment;
    private JTextField txtSalary;

    public UpdateEmployeeFrame() {

        setTitle("Update Employee");

        setSize(450, 350);

        setLayout(null);

        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("Employee ID");
        lblId.setBounds(30, 30, 100, 30);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 30, 200, 30);
        add(txtId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 80, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150, 80, 200, 30);
        add(txtName);

        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(30, 130, 100, 30);
        add(lblDepartment);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(150, 130, 200, 30);
        add(txtDepartment);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setBounds(30, 180, 100, 30);
        add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(150, 180, 200, 30);
        add(txtSalary);

        JButton btnUpdate = new JButton("Update");

        btnUpdate.setBounds(150, 240, 120, 35);

        add(btnUpdate);

        btnUpdate.addActionListener(e -> updateEmployee());

        setVisible(true);
    }

    private void updateEmployee() {

        try {

            Employee employee = new Employee();

            employee.setEmpId(
                    Integer.parseInt(
                            txtId.getText()));

            employee.setName(
                    txtName.getText());

            employee.setDepartment(
                    txtDepartment.getText());

            employee.setSalary(
                    Double.parseDouble(
                            txtSalary.getText()));

            employee.setEmail("updated@gmail.com");
            employee.setMobile("9999999999");
            employee.setJoiningDate(LocalDate.now());

            EmployeeDAO dao =
                    new EmployeeDAOImpl();

            boolean status =
                    dao.updateEmployee(employee);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Updated Successfully");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Update Failed");
            }

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }
}