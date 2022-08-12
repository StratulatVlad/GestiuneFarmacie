package com.example.gestiunefarmacie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Task1Controller implements Initializable {
    @FXML
    private Button cancelButton;

    ObservableList<String> orase = FXCollections.observableArrayList("Timisoara","Iasi","Bucuresti", "Cluj");
    @FXML
    private ChoiceBox comboOras;
    @FXML
    private TableView<Farmacie> farmaciiTable;
    @FXML
    private TableColumn<Farmacie, String> numeCol;
    @FXML
    private TableColumn<Farmacie, String> adresaCol;
    @FXML
    private TableColumn<Farmacie, String> contactCol;
    ObservableList<Farmacie> farmacieObservableList = FXCollections.observableArrayList();
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void afisareButtonOnAction(ActionEvent event) throws SQLException {
            DBconnection dBconnection= new DBconnection();
            Connection connection = dBconnection.getConnection();


            PreparedStatement pr = null;
            ResultSet queryResult = null;

            String sql = "SELECT nume, adresa, telefon FROM Farmacii where oras ='" +comboOras.getValue().toString() + "'";

            try{
                Statement statement=connection.createStatement();
                queryResult= statement.executeQuery(sql);
            }
            catch(Exception e){
                e.printStackTrace();
                e.getCause();
                throw new SQLException("SQL Select statemant returns null");

            }
            farmaciiTable.getItems().clear();
            while(queryResult.next()){

                String nume = queryResult.getString("nume");
                String adresa = queryResult.getString("adresa");
                String telefon = queryResult.getString("telefon");
                farmacieObservableList.add(new Farmacie(nume, adresa, telefon));
                numeCol.setCellValueFactory(new PropertyValueFactory<>("nume"));
                adresaCol.setCellValueFactory(new PropertyValueFactory<>("adresa"));
                contactCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));

            }
            farmaciiTable.setItems(farmacieObservableList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboOras.setItems(orase);
    }
}
