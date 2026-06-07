package com.ems.util;

public class ValidationUtil {

    // Empty Field Validation
    public static boolean isEmptyField(String value) {

        return value == null || value.trim().isEmpty();
    }

    // Email Validation
    public static boolean isValidEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return email != null
                && email.matches(emailRegex);
    }

    // Mobile Validation (10 Digits)
    public static boolean isValidMobile(String mobile) {

        return mobile != null
                && mobile.matches("\\d{10}");
    }

    // Salary Validation
    public static boolean isValidSalary(String salary) {

        try {

            double sal =
                    Double.parseDouble(salary);

            return sal > 0;

        } catch (NumberFormatException e) {

            return false;
        }
    }
}