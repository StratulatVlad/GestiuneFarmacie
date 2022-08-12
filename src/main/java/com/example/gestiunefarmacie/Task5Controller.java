package com.example.gestiunefarmacie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Task5Controller implements Initializable {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField textMedicament;
    @FXML
    private Button afisareButton;
    @FXML
    private TableView<Farmacie> medicamentTable;
    @FXML
    private TableColumn<Farmacie, String> farmaCol;
    @FXML
    private TableColumn<Farmacie, String> orasCol;


    ObservableList<Farmacie> medicamenteObservableList = FXCollections.observableArrayList();

    public Task5Controller() {
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
        DBconnection dBconnection= new DBconnection();
        Connection connection = dBconnection.getConnection();


        PreparedStatement pr = null;
        ResultSet queryResult = null;



        String sql = "SELECT f.nume,f.oras  FROM Farmacii f, Medicamente m where m.cod_farma = f.cod and m.nume_med ='" +textMedicament.getText() + "'";

        try{
            Statement statement=connection.createStatement();
            queryResult= statement.executeQuery(sql);

        }
        catch(Exception e){
            e.printStackTrace();
            e.getCause();
            throw new SQLException("SQL Select statemant returns null");

        }

        medicamentTable.getItems().clear();
        while(queryResult.next()){
            String nume = queryResult.getString("nume");
            String oras = queryResult.getString("oras");
            medicamenteObservableList.add(new Farmacie(nume, oras));
            farmaCol.setCellValueFactory(new PropertyValueFactory<>("nume"));
            orasCol.setCellValueFactory(new PropertyValueFactory<>("oras"));

        }
        medicamentTable.setItems(medicamenteObservableList);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
