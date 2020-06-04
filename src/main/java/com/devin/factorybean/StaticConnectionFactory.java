package com.devin.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticConnectionFactory {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsinfo?useSSL=false","root","123456");
            return conn;
        } catch (ClassNotFoundException e) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
