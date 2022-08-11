module com.example.gestiunefarmacie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gestiunefarmacie to javafx.fxml;
    exports com.example.gestiunefarmacie;
}