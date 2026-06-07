package com.ems.main;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;

public class TestEmployeeDelete {

    public static void main(String[] args) {

        EmployeeDAO dao =
                new EmployeeDAOImpl();

        boolean status =
                dao.deleteEmployee(1);

        if (status) {

            System.out.println(
                    "Employee Deleted Successfully");
        }
        else {

            System.out.println(
                    "Employee Delete Failed");
        }
    }
}