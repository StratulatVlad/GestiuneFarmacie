package com.example.gestiunefarmacie;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public Connection databaseLink;


    public Connection getConnection() {

        String databaseName = "farmadb";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch(Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
