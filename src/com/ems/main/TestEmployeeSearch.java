package com.ems.main;
import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.model.Employee;

public class TestEmployeeSearch {

    public static void main(String[] args) {

        EmployeeDAO dao =
                new EmployeeDAOImpl();

        Employee employee =
                dao.getEmployeeById(1);

        if (employee != null) {

            System.out.println(
                    "ID : " + employee.getEmpId());

            System.out.println(
                    "Name : " + employee.getName());

            System.out.println(
                    "Department : "
                            + employee.getDepartment());
        }
        else {

            System.out.println(
                    "Employee Not Found");
        }
    }
}