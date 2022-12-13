package com.example.rockpaperscissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;

public class SchereSteinPapier_Applc extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File f = new File("src/main/resources/com/example/rockpaperscissors/music/yt1s.com-MiceOnVenus.mp3");
        javafx.scene.media.Media m = new javafx.scene.media.Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        MediaView mv = new MediaView(mp);

        FXMLLoader fxmlLoader = new FXMLLoader(SchereSteinPapier_Applc.class.getResource("Scene_Build_SSP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        stage.setTitle("Schere - Stein - Papier!");

        stage.setScene(scene);
        stage.show();
        mp.play();



    }
    public static void main(String[] args) {
        launch();
    }
}