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
    @FXML
    private Button task2Button;

    @FXML
    private Button task3Button;
    @FXML
    private Button task4Button;
    @FXML
    private Button task5Button;
    @FXML
    private Button task6Button;

    public void task1ButtonOnAction(ActionEvent e){
        createTask1Stage();
    }
    public void task2ButtonOnAction(ActionEvent e){
        createTask2Stage();
    }

    public void task3ButtonOnAction(ActionEvent e){
        createTask3Stage();
    }
    public void task4ButtonOnAction(ActionEvent e){
        createTask4Stage();
    }
    public void task5ButtonOnAction(ActionEvent e){
        createTask5Stage();
    }
    public void task6ButtonOnAction(ActionEvent e){
        createTask6Stage();
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
    public void createTask2Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task2-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 2");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void createTask3Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task3-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 3");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void createTask4Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task4-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 4");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void createTask5Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task5-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 5");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void createTask6Stage(){
        try{

            Parent root= FXMLLoader.load(getClass().getResource("task6-view.fxml"));
            Stage registrationStage= new Stage();
            registrationStage.setTitle("Gestiune Farmacie - Task 6");
            registrationStage.setScene(new Scene(root,540,453));
            registrationStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}