package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class SchereSteinPapier_Control {

    @FXML
    private Button rockButton, paperButton, scissorButton;
    private String choice, rmChoice;
    private int winner = 0;
    private int proof = 0;

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
        proof++;
        ChoiceGenerator();
        choice = "Rock";
        labelChoose.setText("Stein ...");
        if (proof==3){
            randomChoice();
            choice1.setText("Stein");
        }
    }

    @FXML
    private void PaperButtonClicked() {
        proof++;
        ChoiceGenerator();
        choice = "Paper";
        labelChoose.setText("Papier ...");
        if (proof==3){
            randomChoice();
            choice1.setText("Papier");
        }
    }

    @FXML
    private void ScissorButtonClicked() {
        proof++;
        ChoiceGenerator();
        choice = "Scissor";
        labelChoose.setText("Schere ...");
        if (proof == 3){
            randomChoice();
            choice1.setText("Schere");
        }
    }

    @FXML
    private void onClickExit(){
        System.exit(0);
    }

    @FXML
    private void onClickFurther(){
        proof = 0;
        progressbar.setProgress(0);
        labelChoose.setText("Neue Runde!");
        choice1.setText(" ");
        choice2.setText(" ");
        scissorButton.setDisable(false);
        paperButton.setDisable(false);
        rockButton.setDisable(false);
    }





    private void randomChoice() {
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

    private void Highscore() {
    int points = Integer.parseInt(pointsbar.getText());
    int highscorepoints = Integer.parseInt(highscorebar.getText());
        if (points > highscorepoints) {
            highscorepoints = points;
            highscorebar.setText(String.valueOf(highscorepoints));
        }
    }



    private void ChoiceGenerator() {

        if (proof == 1){
            progressbar.setProgress(0.3333333333);
        } else if (proof == 2) {
            progressbar.setProgress(0.6666666666);
        } else if (proof == 3){
            progressbar.setProgress(0.9999999999);
            scissorButton.setDisable(true);
            paperButton.setDisable(true);
            rockButton.setDisable(true);
        }
    }
}
