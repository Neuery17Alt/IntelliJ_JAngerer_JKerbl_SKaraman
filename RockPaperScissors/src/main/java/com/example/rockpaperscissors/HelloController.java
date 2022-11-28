package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button Rock, Paper, Scissor;
    private String choice;
    private boolean free = true;

    @FXML
    private void RockButtonClicked () {
        if (free) {
            choice = "Rock";
            free = false;
        }
    }

    @FXML
    private void PaperButtonClicked () {
        if (free) {
            choice = "Paper";
            free = false;
        }
    }

    @FXML
    private void ScissorButtonClicked () {
        if (free) {
            choice = "Scissor";
            free = false;
        }
    }
}