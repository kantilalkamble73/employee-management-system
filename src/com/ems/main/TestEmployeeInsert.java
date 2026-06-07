package com.ems.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.dao.EmployeeDAO;
import com.ems.db.DBConnection;
import com.ems.model.Employee;

public class TestEmployeeInsert implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee employee) {

        String sql = "INSERT INTO employee "
                + "(name,email,mobile,department,salary,joining_date) "
                + "VALUES (?,?,?,?,?,?)";

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getMobile());
            ps.setString(4, employee.getDepartment());
            ps.setDouble(5, employee.getSalary());

            ps.setDate(
                    6,
                    java.sql.Date.valueOf(
                            employee.getJoiningDate()
                    )
            );

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setEmpId(
                        rs.getInt("emp_id"));

                employee.setName(
                        rs.getString("name"));

                employee.setEmail(
                        rs.getString("email"));

                employee.setMobile(
                        rs.getString("mobile"));

                employee.setDepartment(
                        rs.getString("department"));

                employee.setSalary(
                        rs.getDouble("salary"));

                employee.setJoiningDate(
                        rs.getDate("joining_date")
                          .toLocalDate());

                employeeList.add(employee);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return false;
    }
}