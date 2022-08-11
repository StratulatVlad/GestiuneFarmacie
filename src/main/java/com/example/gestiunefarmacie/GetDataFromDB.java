package com.example.gestiunefarmacie;

import java.sql.*;

public class GetDataFromDB {


    public void getPharma(Orase oras) throws  SQLException{
        DBconnection dBconnection= new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;

        String sql = "SELECT nume FROM Farmacii where oras ='" +oras.value() + "'";

        try{
            Statement statement=connection.createStatement();
            queryResult= statement.executeQuery(sql);
        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }

        while(queryResult.next()){
            System.out.println(queryResult.getString("nume"));
        }

    }
}