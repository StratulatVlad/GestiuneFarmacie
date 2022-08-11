package com.example.gestiunefarmacie;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public Connection databaseLink;
    public Connection getConnection() {

        String USERNAME = "root";
        String PASSWORD = "root";
        String CONN = "jdbc:mysql://localhost:3306/farmadb";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink =  DriverManager.getConnection(CONN,USERNAME,PASSWORD);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return databaseLink;
    }
}
