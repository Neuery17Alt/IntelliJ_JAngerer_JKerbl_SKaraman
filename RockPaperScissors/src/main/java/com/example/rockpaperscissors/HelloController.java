package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.Random;

public class HelloController {

    @FXML
    private Button rockButton, paperButton, scissorButton;
    private String choice, rmChoice;

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
    }

    private void Winner () {
        if (choice.equals("Rock") && rmChoice.equals("Scissor")) {
            System.out.println("Gewinner ist Spieler1");
            paperButton.setVisible(false);
        } else {
            System.out.println("Gewinner ist Spieler2");
            scissorButton.setVisible(false);
        }
        if (choice.equals("Paper") && rmChoice.equals("Rock")) {
            System.out.println("Gewinner ist Spieler1");
            scissorButton.setVisible(false);
        } else {
            System.out.println("Gewinner ist Spieler2");
            scissorButton.setVisible(false);
        }
        if (choice.equals("Scissor") && rmChoice.equals("Paper")) {
            System.out.println("Gewinner ist Spieler1");
            rockButton.setVisible(false);
        } else {
            System.out.println("Gewinner ist Spieler2");
            rockButton.setVisible(false);
        }
        System.out.println("Hallihallo");

        System.out.println("Fehler!");
    }
}