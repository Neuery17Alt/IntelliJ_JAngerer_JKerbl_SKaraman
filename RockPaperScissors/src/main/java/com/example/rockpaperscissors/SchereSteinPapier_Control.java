package com.example.rockpaperscissors;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;


import java.util.Random;

public class SchereSteinPapier_Control {

    @FXML
    private Button rockButton, paperButton, scissorButton;
    private String choice, rmChoice;
    private int winner = 0;

    @FXML
    private Label choice1, choice2;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private Label pointsbar, highscorebar;
    @FXML
    private Label labelChoose, label_Winner;

    @FXML
    private void RockButtonClicked() {
        choice = "Rock";
        labelChoose.setText("Stein ...");
        choice1.setText("Stein");
        Load();
    }

    @FXML
    private void PaperButtonClicked() {
        choice = "Paper";
        labelChoose.setText("Papier ...");
        choice1.setText("Papier");
        Load();
    }

    @FXML
    private void ScissorButtonClicked() {
        choice = "Scissor";
        labelChoose.setText("Schere ...");
        choice1.setText("Schere");
        Load();
    }

    @FXML
    private void onClickExit(){
        System.exit(0);
    }

    @FXML
    private void onClickFurther(){
        labelChoose.setText("Neue Runde!");
        choice1.setText(" ");
        choice2.setText(" ");
        scissorButton.setDisable(false);
        paperButton.setDisable(false);
        rockButton.setDisable(false);
    }


    public void RandomChoice() {
        int num = 0;

        Random random = new Random();
        num = random.nextInt(3) + 1;

        if (num == 1) {
            rmChoice = "Rock";
            choice2.setText("Stein");
        } else if (num == 2) {
            rmChoice = "Paper";
            choice2.setText("Papier");
        } else {
            rmChoice = "Scissor";
            choice2.setText("Schere");
        }
        Winner();

    }

    private void PlayerOne(){
        label_Winner.setText("Spieler 1");
    }

    private void PlayerTwo(){
        label_Winner.setText("Spieler 2");
    }

    private void WinnerUndecided(){
        label_Winner.setText("Unentschieden!");
    }



    private void Winner() {
        if (choice.equals("Rock") && rmChoice.equals("Scissor")) {
            winner = 1;
            PlayerOne();
        } else if (choice.equals("Paper") && rmChoice.equals("Rock")) {
            winner = 1;
            PlayerOne();
        } else if (choice.equals("Scissor") && rmChoice.equals("Paper")) {
            winner = 1;
            PlayerOne();
        } else if (choice.equals(rmChoice)) {
            winner = 0;
        } else {
            winner = 2;
            PlayerTwo();
        }
        Points();
        Highscore();
    }

    private void Points() {
        int points = Integer.parseInt(pointsbar.getText());
        if (winner == 1) {
            points = points + 2;
        } else if (winner == 2) {
            if (points != 0) {
                points--;
            }
        } else if (winner == 0){
            WinnerUndecided();
        }
            winner = 0;
            pointsbar.setText(String.valueOf(points));
    }

    public void Highscore() {
    int points = Integer.parseInt(pointsbar.getText());
    int highscorepoints = Integer.parseInt(highscorebar.getText());
        if (points > highscorepoints) {
            highscorepoints = points;
            highscorebar.setText(String.valueOf(highscorepoints));
        }
    }

    public void ButtonsDisable() {
            scissorButton.setDisable(true);
            paperButton.setDisable(true);
            rockButton.setDisable(true);
        }

    private void Load () {
        ProgressBarClass progressBar = new ProgressBarClass();
        progressBar.test(progressbar, this);
    }

    }
