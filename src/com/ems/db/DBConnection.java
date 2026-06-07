package com.ems.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private DBConnection() {
        // Prevent object creation
    }

    public static Connection getConnection() {

        Connection connection = null;

        try {
            // Load properties file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);

            // Read values from file
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

        } catch (ClassNotFoundException | SQLException | java.io.IOException e) {
            System.out.println("❌ Database Connection Error");
            e.printStackTrace();
        }

        return connection;
    }
}