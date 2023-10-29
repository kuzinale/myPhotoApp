package com.example.myphotoapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class HelloApplication extends Application {
    public static ObservableList<String> items= FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Enumeration<Driver> drvs = DriverManager.getDrivers();
        while (drvs.hasMoreElements()){
            System.out.println(drvs.nextElement());
        }
        //MySQL.putPhoto("Me","C:\\Users\\alexa\\OneDrive\\Pictures\\photo_2019-11-28_13-11-12.jpg");

    }


    public static void main(String[] args) {
        launch();
    }

}