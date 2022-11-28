package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button Rock, Paper, Scissor;
    private String choice, rmChoice;

    @FXML
    private void RockButtonClicked () {
            choice = "Rock";
            randomChoice();
    }

    @FXML
    private void PaperButtonClicked () {
            choice = "Paper";
            randomChoice();
    }

    @FXML
    private void ScissorButtonClicked () {
            choice = "Scissor";
            randomChoice();
    }

    private void randomChoice () {
        int num = 0;

        Random random = new Random();
        num = random.nextInt(3)+1;
        System.out.println(num);

        if (num == 1) {
            rmChoice = "Rock";
        } else if (num == 2) {
            rmChoice = "Paper";
        } else {
            rmChoice = "Scissor";
        }

    }
}