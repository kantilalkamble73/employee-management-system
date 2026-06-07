package com.ems.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class ViewEmployeeFrame extends JFrame {

    private JTable table;

    private DefaultTableModel model;

    public ViewEmployeeFrame() {

        setTitle("View Employees");

        setSize(800, 500);

        setLocationRelativeTo(null);

        setLayout(null);

        String[] columns = {
                "ID",
                "Name",
                "Email",
                "Mobile",
                "Department",
                "Salary",
                "Joining Date"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                20,
                20,
                740,
                400);

        add(scrollPane);

        loadEmployees();

        setVisible(true);
    }

    private void loadEmployees() {

        EmployeeDAO dao =
                new EmployeeDAOImpl();

        List<Employee> employeeList =
                dao.getAllEmployees();

        for (Employee employee : employeeList) {

            Object[] row = {

                    employee.getEmpId(),

                    employee.getName(),

                    employee.getEmail(),

                    employee.getMobile(),

                    employee.getDepartment(),

                    employee.getSalary(),

                    employee.getJoiningDate()
            };

            model.addRow(row);
        }
    }
}