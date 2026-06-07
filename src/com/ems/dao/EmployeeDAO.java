package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDAO {

    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int empId);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int empId);
}