package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchereSteinPapier_Applc extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SchereSteinPapier_Applc.class.getResource("Scene_Build_SSP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        stage.setTitle("Schere - Stein - Papier!");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}