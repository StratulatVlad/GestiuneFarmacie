package com.example.gestiunefarmacie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Task2Controller {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField textLuna;
    @FXML
    private TextField textFarma;

    @FXML
    private Label afisareLabel;
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
        DBconnection dBconnection= new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;



        String sql = "SELECT count(c.cod_com) as numar_comenzi,sum(c.cantitate_com * m.pret) as suma_comanda, avg(c.cantitate_com * m.pret) as medie_comanda FROM Farmacii f, Medicamente m, Comenzi c where c.cod_med = m.cod_med and m.cod_farma = f.cod and f.nume = '"+textFarma.getText()+"' and c.data_livrare >= '2022-"+textLuna.getText()+"-01' and c.data_livrare <= '2022-"+textLuna.getText()+"-31'";

        try{
            Statement statement=connection.createStatement();
            queryResult= statement.executeQuery(sql);

        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }
        String nr = null;
        String sc = null;
        String vc = null;
        while(queryResult.next()){
                nr = queryResult.getString("numar_comenzi");
                sc = queryResult.getString("suma_comanda");
                vc = queryResult.getString("medie_comanda");
        }
        afisareLabel.setText(nr + " " + sc + " " + vc);


    }
}
