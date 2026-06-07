package com.ems.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.dao.EmployeeDAO;
import com.ems.db.DBConnection;
import com.ems.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

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
                Connection connection = DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql);

                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setEmpId(rs.getInt("emp_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setMobile(rs.getString("mobile"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getDouble("salary"));

                if (rs.getDate("joining_date") != null) {
                    employee.setJoiningDate(
                            rs.getDate("joining_date")
                              .toLocalDate());
                }

                employeeList.add(employee);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int empId) {

        String sql = "SELECT * FROM employee WHERE emp_id = ?";

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Employee employee = new Employee();

                employee.setEmpId(rs.getInt("emp_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setMobile(rs.getString("mobile"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getDouble("salary"));

                if (rs.getDate("joining_date") != null) {
                    employee.setJoiningDate(
                            rs.getDate("joining_date")
                              .toLocalDate());
                }

                return employee;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {

        String sql = "UPDATE employee SET "
                + "name=?, "
                + "email=?, "
                + "mobile=?, "
                + "department=?, "
                + "salary=?, "
                + "joining_date=? "
                + "WHERE emp_id=?";

        try (
                Connection connection =
                        DBConnection.getConnection();

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
                            employee.getJoiningDate()));

            ps.setInt(7, employee.getEmpId());

            int rowsAffected =
                    ps.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    @Override
    public boolean deleteEmployee(int empId) {

        String sql = "DELETE FROM employee WHERE emp_id=?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, empId);

            int rowsAffected =
                    ps.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}