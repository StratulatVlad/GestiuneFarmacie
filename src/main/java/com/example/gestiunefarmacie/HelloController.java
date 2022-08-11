package com.example.gestiunefarmacie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class HelloController{

    @FXML
    private Button afisareFarma;

    @FXML
    private Label dbstatus;


    public void afisareFarmaButtonOnAction(ActionEvent e){
        GetDataFromDB getDataFromDB= new GetDataFromDB();
        try {
            getDataFromDB.getPharma(Orase.Timisoara);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}