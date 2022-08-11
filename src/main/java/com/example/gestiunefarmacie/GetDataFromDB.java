package com.example.gestiunefarmacie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDataFromDB {
    public Connection connection;

    public GetDataFromDB(){
        try{
            this.connection = DBconnection.getConnection();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        if(this.connection == null)
        {
            System.exit(1);
        }
    }

    public boolean isDatabaseConnected(){
        return this.connection != null;
    }

    public void getPharma(Orase oras) throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT nume FROM Farmacii where oras = ?";

        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1,oras.value());

            rs = pr.executeQuery();

            while(rs.next())
            {
                System.out.println(sql);
            }
        }
        catch(Exception ex){
            System.exit(2);
        }
        finally{
            pr.close();
            rs.close();
        }
    }
}
