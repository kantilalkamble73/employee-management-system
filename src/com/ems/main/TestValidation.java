package com.ems.main;

import com.ems.util.ValidationUtil;

public class TestValidation {

    public static void main(String[] args) {

        System.out.println(
                ValidationUtil.isValidEmail(
                        "kantilal@gmail.com"));

        System.out.println(
                ValidationUtil.isValidMobile(
                        "9876543210"));

        System.out.println(
                ValidationUtil.isValidSalary(
                        "35000"));
    }
}