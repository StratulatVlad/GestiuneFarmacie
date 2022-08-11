package com.example.gestiunefarmacie;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    GetDataFromDB getdata = new GetDataFromDB();
    @FXML
    private Button afisareFarma;

    @FXML
    private Label dbstatus;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(this.getdata.isDatabaseConnected()){
            this.dbstatus.setText("Connected");
        }
        else {
            this.dbstatus.setText("Not connected");
        }
    }
}