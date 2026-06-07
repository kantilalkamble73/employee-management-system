package com.ems.model;

import java.time.LocalDate;

public class Employee {

    private int empId;
    private String name;
    private String email;
    private String mobile;
    private String department;
    private double salary;
    private LocalDate joiningDate;

    public Employee() {
    }

    public Employee(int empId,
                    String name,
                    String email,
                    String mobile,
                    String department,
                    double salary,
                    LocalDate joiningDate) {

        this.empId = empId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {

        return "Employee [empId=" + empId
                + ", name=" + name
                + ", email=" + email
                + ", mobile=" + mobile
                + ", department=" + department
                + ", salary=" + salary
                + ", joiningDate=" + joiningDate
                + "]";
    }
}