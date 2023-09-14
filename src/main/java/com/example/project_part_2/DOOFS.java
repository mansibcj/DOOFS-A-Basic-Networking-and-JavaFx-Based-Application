package com.example.project_part_2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class DOOFS extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DOOFS.class.getResource("StartingPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DOOFS!");

        //Make Sure to Change Directory to Get Output....
        stage.getIcons().add(new Image("C:\\Academic Materials\\1-2\\CSE 108\\Project Part 2\\Project_Part_2\\doofs.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}