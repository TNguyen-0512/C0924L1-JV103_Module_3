package com.example.do_an_ca_nhan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/m3_casestudy";
    private static final String USER ="root";
    private static final String PASS ="12345";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Loi ket noi database: " + e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Ket noi database thanh cong");
        return conn;
    }
}