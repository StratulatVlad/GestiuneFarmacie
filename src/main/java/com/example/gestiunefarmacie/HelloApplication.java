package com.example.gestiunefarmacie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primarystage.setScene(new Scene(root, 637, 547));
        primarystage.setTitle("Gestiune Farmacie");
        primarystage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}