package com.ems.main;

import java.util.List;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class TestEmployeeView {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAOImpl();

        List<Employee> employeeList =
                dao.getAllEmployees();

        for (Employee employee : employeeList) {

            System.out.println(
                    "ID : " + employee.getEmpId());

            System.out.println(
                    "Name : " + employee.getName());

            System.out.println(
                    "Email : " + employee.getEmail());

            System.out.println(
                    "Mobile : " + employee.getMobile());

            System.out.println(
                    "Department : " + employee.getDepartment());

            System.out.println(
                    "Salary : " + employee.getSalary());

            System.out.println(
                    "Joining Date : "
                            + employee.getJoiningDate());

            System.out.println(
                    "=================================");
        }
    }
}