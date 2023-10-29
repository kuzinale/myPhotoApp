package com.example.myphotoapp;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageView;
    @FXML
    private GridPane root;
    @FXML
    private TextField pathId;
    @FXML
    private ListView<String> listId;
    ArrayList<PicturesSet> pictures;

    @FXML
    protected void onHelloButtonClick() {
        listId.getItems().clear();
        pictures = MySQL.getPhotos();

    }
    @FXML
    protected void btnLoadClick(){
        MySQL.putPhoto("Photo",pathId.getText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HelloApplication.items.addListener(new ListChangeListener() {

            @Override
            public void onChanged(Change c) {
                listId.setItems(c.getList());
            }
        });

        pictures = MySQL.getPhotos();

    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        imageView.setImage(pictures.get(listId.getSelectionModel().getSelectedIndex()).picture);
        System.out.println(listId.getSelectionModel().getSelectedIndex());
    }
}