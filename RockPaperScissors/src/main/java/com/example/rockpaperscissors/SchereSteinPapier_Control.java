package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.*;


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

    /**
     * If Rockbutton is clicked disable all Buttons set the choice, the choose-Label and choice1
     * to Rock/Stein and then beginn with the loading progressbar
     */
    @FXML
    private void RockButtonClicked() {
        ButtonsDisable();
        choice = "Rock";
        labelChoose.setText("Stein ...");
        choice1.setText("Stein");
        Load();
    }

    /**
     * If Paperbutton is clicked disable all Buttons set the choice, the choose-Label and choice1
     * to Paper/Papier and then beginn with the loading progressbar
     */

    @FXML
    private void PaperButtonClicked() {
        ButtonsDisable();
        choice = "Paper";
        labelChoose.setText("Papier ...");
        choice1.setText("Papier");

        Load();
    }

    /**
     * If Scissorbutton is clicked disable all Buttons set the choice, the choose-Label and choice1
     * to Scissor/Schere and then beginn with the loading progressbar
     */

    @FXML
    private void ScissorButtonClicked() {
        ButtonsDisable();
        choice = "Scissor";
        labelChoose.setText("Schere ...");
        choice1.setText("Schere");
        Load();
    }

    /**
     * If the exit-Button is clicked shutdown the programm
     */
    @FXML
    private void onClickExit(){
        System.exit(0);
    }

    /**
     * If the Further-Button is clicked set the Winner-visibility to false and
     * the Buttons on enabled. This button is to start a new round!
     */

    @FXML
    private void onClickFurther(){
        labelChoose.setText("Neue Runde!");
        label_Winner.setVisible(false);
        choice1.setText(" ");
        choice2.setText(" ");
        scissorButton.setDisable(false);
        paperButton.setDisable(false);
        rockButton.setDisable(false);
    }

    /**
     * If the Player chose Rock/Paper/Scissor it Generates a
     * random pick for the computer. After that it goes to the Winner-function
     */

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
        label_Winner.setVisible(true);

    }

    /**
     * If it generated a random pick it checks who won, if
     * they have the same it´s a draw
     */

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

    /**
     * These three methods just set the winner-Label to the Winner/Draw
     */
    private void PlayerOne(){
        label_Winner.setText("Spieler 1");
    }

    private void PlayerTwo(){
        label_Winner.setText("Spieler 2");
    }

    private void WinnerUndecided(){
        label_Winner.setText("Unentschieden!");
    }


    /**
     * In this method it calculates the earned points, if you lose
     * you get -1 points, if you win +1 points and if it´s a draw you get
     * 0 points
     */
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

    /**
     * This method calculates the highscore you reached,
     * if you had 12 points a few minutes ago, but now you are down
     * to 6 points it still shows the highest amount of points (12)
     */
    public void Highscore() {
        int points = Integer.parseInt(pointsbar.getText());
        int highscorepoints = Integer.parseInt(highscorebar.getText());
        if (points > highscorepoints) {
            highscorepoints = points;
            highscorebar.setText(String.valueOf(highscorepoints));
        }
    }

    /**
     * Disables buttons if the player already chose something
     */

    public void ButtonsDisable() {
        scissorButton.setDisable(true);
        paperButton.setDisable(true);
        rockButton.setDisable(true);
    }

    /**
     * This method leads to the loading progressbar
     */
    private void Load () {
        ProgressBarClass progressBar = new ProgressBarClass();
        progressBar.test(progressbar, this);
    }

}