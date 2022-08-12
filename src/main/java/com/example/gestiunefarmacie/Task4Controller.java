package com.example.gestiunefarmacie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Task4Controller {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField textAn;
    @FXML
    private Button afisareButton;
    @FXML
    private Label farmaLabel;
    @FXML
    private Label orasLabel;
    @FXML
    private Label sumaLabel;
    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
        DBconnection dBconnection= new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;




        String sql = "SELECT f.cod,f.oras,f.nume,sum(c.cantitate_com * m.pret) as suma_comanda FROM Farmacii f, Medicamente m, Comenzi c where c.cod_med = m.cod_med and m.cod_farma = f.cod and c.data_livrare >= '"+textAn.getText()+"-01-01' and c.data_livrare <= '"+textAn.getText()+"-12-31' group by f.cod,f.oras,f.nume";

        try{
            Statement statement=connection.createStatement();
            queryResult= statement.executeQuery(sql);

        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }

        Integer max_suma = 0;
        String max_farma = null;
        String max_oras = null;
        while(queryResult.next()){
            System.out.println(queryResult.getString("suma_comanda")+" " + queryResult.getString("nume") +" "+ queryResult.getString("cod"));
            if(max_suma <Integer.parseInt(queryResult.getString("suma_comanda"))){
                max_suma = Integer.parseInt(queryResult.getString("suma_comanda"));
                max_farma = queryResult.getString("nume");
                max_oras = queryResult.getString("oras");
            }

        }

        farmaLabel.setText(max_farma);
        orasLabel.setText(max_oras);
        sumaLabel.setText(max_suma.toString() + " lei");


    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
