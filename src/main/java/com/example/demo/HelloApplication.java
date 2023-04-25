package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.io.IOException;

import static javafx.scene.text.FontWeight.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        Button btn2 = new Button("Sign up");


        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().addAll(btn, btn2);
        grid.add(hbBtn2, 0, 4,3,1);



        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 7);

        btn.setOnAction(event -> {

            // Crea una ListView con 3 elementos
            ListView<String> listView = new ListView<>();
            listView.getItems().addAll("Elemento 1", "Elemento 2", "Elemento 3");

            // Crea un ToggleGroup con dos opciones
            RadioButton option1 = new RadioButton("Opción 1");
            RadioButton option2 = new RadioButton("Opción 2");
            ToggleGroup toggleGroup = new ToggleGroup();
            option1.setToggleGroup(toggleGroup);
            option2.setToggleGroup(toggleGroup);

            // Crea un VBox para contener la lista y el ToggleGroup
            VBox vBox = new VBox(10, listView, option1, option2);

            Button backButton = new Button("Volver");

            // Agrega un manejador de eventos para el botón "Volver"
            backButton.setOnAction(backEvent -> {
                primaryStage.getScene().setRoot(grid);
            });

            // Agrega el botón "Volver" al VBox que contiene la lista y el ToggleGroup
            vBox.getChildren().add(backButton);

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(listView);
            primaryStage.getScene().setRoot(vBox);


        });


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}