module com.example.gestiunefarmacie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestiunefarmacie to javafx.fxml;
    exports com.example.gestiunefarmacie;
}