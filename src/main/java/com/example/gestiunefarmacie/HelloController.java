package com.example.gestiunefarmacie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController{

    @FXML
    private Button task1Button;



    public void task1ButtonOnAction(ActionEvent e){
        createTask1Stage();
    }

    public void createTask1Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task1-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 1");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}