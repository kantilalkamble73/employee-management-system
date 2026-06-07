package com.ems.ui;

import java.time.LocalDate;
import com.ems.util.ValidationUtil;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class AddEmployeeFrame extends JFrame {

    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtMobile;
    private JTextField txtDepartment;
    private JTextField txtSalary;

    private JButton btnSave;

    public AddEmployeeFrame() {

        setTitle("Add Employee");

        setSize(500, 450);

        setLayout(null);

        setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 40, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(170, 40, 200, 30);
        add(txtName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 90, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(170, 90, 200, 30);
        add(txtEmail);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(50, 140, 100, 30);
        add(lblMobile);

        txtMobile = new JTextField();
        txtMobile.setBounds(170, 140, 200, 30);
        add(txtMobile);

        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(50, 190, 100, 30);
        add(lblDepartment);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(170, 190, 200, 30);
        add(txtDepartment);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setBounds(50, 240, 100, 30);
        add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(170, 240, 200, 30);
        add(txtSalary);

        btnSave = new JButton("Save Employee");
        btnSave.setBounds(150, 320, 180, 40);
        add(btnSave);

        btnSave.addActionListener(e -> saveEmployee());

        setVisible(true);
    }
    private void saveEmployee() {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        String department = txtDepartment.getText();
        String salary = txtSalary.getText();

        // Empty Field Validation
        if (ValidationUtil.isEmptyField(name)
                || ValidationUtil.isEmptyField(email)
                || ValidationUtil.isEmptyField(mobile)
                || ValidationUtil.isEmptyField(department)
                || ValidationUtil.isEmptyField(salary)) {

            JOptionPane.showMessageDialog(
                    this,
                    "All Fields Are Required");

            return;
        }

        // Email Validation
        if (!ValidationUtil.isValidEmail(email)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Email");

            return;
        }

        // Mobile Validation
        if (!ValidationUtil.isValidMobile(mobile)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Mobile Number Must Be 10 Digits");

            return;
        }

        // Salary Validation
        if (!ValidationUtil.isValidSalary(salary)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Salary");

            return;
        }

        try {

            Employee employee = new Employee();

            employee.setName(name);
            employee.setEmail(email);
            employee.setMobile(mobile);
            employee.setDepartment(department);
            employee.setSalary(Double.parseDouble(salary));

            employee.setJoiningDate(LocalDate.now());

            EmployeeDAO dao =
                    new EmployeeDAOImpl();

            boolean status =
                    dao.addEmployee(employee);

            if (status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Added Successfully");

                // Clear Form
                txtName.setText("");
                txtEmail.setText("");
                txtMobile.setText("");
                txtDepartment.setText("");
                txtSalary.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Not Added");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }
}