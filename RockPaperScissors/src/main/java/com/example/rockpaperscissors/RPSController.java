package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.Random;

public class RPSController {

    @FXML
    private Button rockButton, paperButton, scissorButton;
    @FXML
    private Label pointsbar;
    private String choice, rmChoice;
    private int winner = 0;

    @FXML
    private ProgressBar progressbar;

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
        Winner();

    }

    private void Winner () {
        if (choice.equals("Rock") && rmChoice.equals("Scissor")) {
            winner = 1;
        } else if (choice.equals("Paper") && rmChoice.equals("Rock")) {
            winner = 1;
        } else if (choice.equals("Scissor") && rmChoice.equals("Paper")) {
            winner = 1;
        } else if (choice.equals(rmChoice)){
            winner = 0;
        } else {
            winner = 2;
        }
        Points();
    }

    private void Points () {
        int points = Integer.parseInt(pointsbar.getText());

        if (winner == 1) {
            points = points + 2;
        } else if (winner == 2) {
            if (points != 0) {
                points--;
            }
        }
            winner = 0;

            pointsbar.setText("" + points);
    }

    private void Outprint () {

    }
}