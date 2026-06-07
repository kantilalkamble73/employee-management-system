package com.ems.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class SearchEmployeeFrame extends JFrame {

    private JTextField txtEmpId;

    public SearchEmployeeFrame() {

        setTitle("Search Employee");

        setSize(400, 250);

        setLayout(null);

        setLocationRelativeTo(null);

        JLabel lblId =
                new JLabel("Employee ID");

        lblId.setBounds(
                40,
                40,
                100,
                30);

        add(lblId);

        txtEmpId =
                new JTextField();

        txtEmpId.setBounds(
                150,
                40,
                150,
                30);

        add(txtEmpId);

        JButton btnSearch =
                new JButton("Search");

        btnSearch.setBounds(
                120,
                100,
                120,
                35);

        add(btnSearch);

        btnSearch.addActionListener(e -> searchEmployee());

        setVisible(true);
    }

    private void searchEmployee() {

        try {

            int empId =
                    Integer.parseInt(
                            txtEmpId.getText());

            EmployeeDAO dao =
                    new EmployeeDAOImpl();

            Employee employee =
                    dao.getEmployeeById(empId);

            if (employee != null) {

                JOptionPane.showMessageDialog(
                        this,

                        "ID : " + employee.getEmpId()
                        + "\nName : " + employee.getName()
                        + "\nDepartment : "
                        + employee.getDepartment()
                        + "\nSalary : "
                        + employee.getSalary());

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Not Found");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Employee ID");
        }
    }
}