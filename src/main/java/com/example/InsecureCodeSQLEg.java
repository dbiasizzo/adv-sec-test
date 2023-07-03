package com.example;

import java.sql.*;

public class InsecureCodeSQLEg {
    public static void insecure() {
        String username = "user";
        String password = "pass";

        String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
