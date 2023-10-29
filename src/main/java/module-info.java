module com.example.myphotoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.myphotoapp to javafx.fxml;
    exports com.example.myphotoapp;
}