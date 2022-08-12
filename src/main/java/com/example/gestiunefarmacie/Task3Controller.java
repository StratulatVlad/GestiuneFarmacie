package com.example.gestiunefarmacie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Task3Controller {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField textAn;
    @FXML
    private TextField textFarma;
    @FXML
    private Button afisareButton;
    @FXML
    private Label numarLabel;
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
        DBconnection dBconnection= new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;



        String sql = "SELECT *  FROM Farmacii f, Medicamente m, Comenzi c where c.cod_med = m.cod_med and m.cod_farma = f.cod and f.nume = '"+textFarma.getText()+"' and m.categorie ='Antibiotic' and c.data_livrare >= '"+textAn.getText()+"-01-01' and c.data_livrare <= '"+textAn.getText()+"-12-31'";

        try{
            Statement statement=connection.createStatement();
            queryResult= statement.executeQuery(sql);

        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }
        Integer i=0;
        while(queryResult.next()){
            i++;
        }
        numarLabel.setText(String.valueOf(i));


    }
}
