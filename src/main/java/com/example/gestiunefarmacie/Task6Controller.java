package com.example.gestiunefarmacie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Task6Controller implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Button afisareButton;

    ObservableList<String> orase = FXCollections.observableArrayList("Timisoara","Iasi","Bucuresti", "Cluj");

    @FXML
    private ChoiceBox comboOras;

    @FXML
    private TextField textMedicament;
    @FXML
    private Label cantitateLabel;

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
        DBconnection dBconnection = new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;

        String sql = "SELECT f.oras,m.nume_med,sum(m.cantitate) as cantitate_totala FROM Farmacii f,Medicamente m where m.cod_farma = f.cod and oras ='" + comboOras.getValue().toString() + "' and m.nume_med ='" + textMedicament.getText() + "'";

        try {
            Statement statement = connection.createStatement();
            queryResult = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }

        String cant = null;
        while (queryResult.next()) {
            cant = queryResult.getString("cantitate_totala");
        }
        cantitateLabel.setText(cant);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboOras.setItems(orase);
    }
}
