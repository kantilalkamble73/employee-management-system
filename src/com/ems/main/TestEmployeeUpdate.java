package com.ems.main;

import java.time.LocalDate;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class TestEmployeeUpdate {

    public static void main(String[] args) {

        Employee employee = new Employee();

        employee.setEmpId(1);

        employee.setName("Kantilal Kamble");
        employee.setEmail("kantilal@gmail.com");
        employee.setMobile("9999999999");
        employee.setDepartment("Software Development");
        employee.setSalary(50000);
        employee.setJoiningDate(LocalDate.now());

        EmployeeDAO dao =
                new EmployeeDAOImpl();

        boolean status =
                dao.updateEmployee(employee);

        if (status) {

            System.out.println(
                    "Employee Updated Successfully");
        }
        else {

            System.out.println(
                    "Employee Update Failed");
        }
    }
}