package com.mycompany.paschalis;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class PrimaryController {

    GameLogic game = new GameLogic();

    @FXML
    private Button r1b1 = new Button();
    @FXML
    private Button r1b2 = new Button();
    @FXML
    private Button r1b3 = new Button();
    @FXML
    private Button r1b4 = new Button();
    @FXML
    private Button r1b5 = new Button();
    @FXML
    private Button r1b6 = new Button();
    @FXML
    private Button r1b7 = new Button();
    @FXML
    private Button r1b8 = new Button();
    @FXML
    private Button r1b9 = new Button();

    @FXML
    private Button r2b1 = new Button();
    @FXML
    private Button r2b2 = new Button();
    @FXML
    private Button r2b3 = new Button();
    @FXML
    private Button r2b4 = new Button();
    @FXML
    private Button r2b5 = new Button();
    @FXML
    private Button r2b6 = new Button();
    @FXML
    private Button r2b7 = new Button();
    @FXML
    private Button r2b8 = new Button();
    @FXML
    private Button r2b9 = new Button();

    @FXML
    private Button r3b1 = new Button();
    @FXML
    private Button r3b2 = new Button();
    @FXML
    private Button r3b3 = new Button();
    @FXML
    private Button r3b4 = new Button();
    @FXML
    private Button r3b5 = new Button();
    @FXML
    private Button r3b6 = new Button();
    @FXML
    private Button r3b7 = new Button();
    @FXML
    private Button r3b8 = new Button();
    @FXML
    private Button r3b9 = new Button();

    @FXML
    private Button r4b1 = new Button();
    @FXML
    private Button r4b2 = new Button();
    @FXML
    private Button r4b3 = new Button();
    @FXML
    private Button r4b4 = new Button();
    @FXML
    private Button r4b5 = new Button();
    @FXML
    private Button r4b6 = new Button();
    @FXML
    private Button r4b7 = new Button();
    @FXML
    private Button r4b8 = new Button();
    @FXML
    private Button r4b9 = new Button();

    @FXML
    private Button r5b1 = new Button();
    @FXML
    private Button r5b2 = new Button();
    @FXML
    private Button r5b3 = new Button();
    @FXML
    private Button r5b4 = new Button();
    @FXML
    private Button r5b5 = new Button();
    @FXML
    private Button r5b6 = new Button();
    @FXML
    private Button r5b7 = new Button();
    @FXML
    private Button r5b8 = new Button();
    @FXML
    private Button r5b9 = new Button();

    @FXML
    private Button r6b1 = new Button();
    @FXML
    private Button r6b2 = new Button();
    @FXML
    private Button r6b3 = new Button();
    @FXML
    private Button r6b4 = new Button();
    @FXML
    private Button r6b5 = new Button();
    @FXML
    private Button r6b6 = new Button();
    @FXML
    private Button r6b7 = new Button();
    @FXML
    private Button r6b8 = new Button();
    @FXML
    private Button r6b9 = new Button();

    @FXML
    private Button r7b1 = new Button();
    @FXML
    private Button r7b2 = new Button();
    @FXML
    private Button r7b3 = new Button();
    @FXML
    private Button r7b4 = new Button();
    @FXML
    private Button r7b5 = new Button();
    @FXML
    private Button r7b6 = new Button();
    @FXML
    private Button r7b7 = new Button();
    @FXML
    private Button r7b8 = new Button();
    @FXML
    private Button r7b9 = new Button();

    @FXML
    private Button r8b1 = new Button();
    @FXML
    private Button r8b2 = new Button();
    @FXML
    private Button r8b3 = new Button();
    @FXML
    private Button r8b4 = new Button();
    @FXML
    private Button r8b5 = new Button();
    @FXML
    private Button r8b6 = new Button();
    @FXML
    private Button r8b7 = new Button();
    @FXML
    private Button r8b8 = new Button();
    @FXML
    private Button r8b9 = new Button();

    @FXML
    private Button r9b1 = new Button();
    @FXML
    private Button r9b2 = new Button();
    @FXML
    private Button r9b3 = new Button();
    @FXML
    private Button r9b4 = new Button();
    @FXML
    private Button r9b5 = new Button();
    @FXML
    private Button r9b6 = new Button();
    @FXML
    private Button r9b7 = new Button();
    @FXML
    private Button r9b8 = new Button();
    @FXML
    private Button r9b9 = new Button();

    @FXML
    private Label HasLostLabel = new Label();
    @FXML
    private Label Score = new Label();
    @FXML
    private Label MaxScore = new Label();
    
    @FXML
    private Button sm = new Button();

    private Boolean mineFlag = false;

    private Boolean hasLost = false;

    private int score = 0;
    private int maxScore = 0;
    private int numberOfMines = game.getNumberOfMines();

    private void resetButton(Button btn) {
        btn.setText("?");
        btn.setStyle("");

    }

    private void checkIfHasLost() {
        hasLost = game.getHasLost();

        if (hasLost) {
            HasLostLabel.setText("ΕΧΑΣΕΣ!");
        } else {
            HasLostLabel.setText("");
        }

        if (numberOfMines == 0) {
            HasLostLabel.setText("ΚΕΡΔΙΣΕΣ!");
            hasLost = true; // gia na pagosei to painidi
        }
    }

    private void updateScore() {
        score = game.getScore();
        if (score > maxScore) {
            maxScore = score;
        }
        Score.setText("Score: " + String.valueOf(score));
        MaxScore.setText("Max score: " + String.valueOf(maxScore));
    }

    @FXML
    private void restartGame() {
        game.newGame();

        mineFlag = false;
        numberOfMines = game.getNumberOfMines();
        checkIfHasLost();
        score = 0;
        updateScore();
        
        sm.setStyle("-fx-background-color: #B9CDDA");
        mineFlag = false;

        resetButton(r1b1);
        resetButton(r1b2);
        resetButton(r1b3);
        resetButton(r1b4);
        resetButton(r1b5);
        resetButton(r1b6);
        resetButton(r1b7);
        resetButton(r1b8);
        resetButton(r1b9);

        resetButton(r2b1);
        resetButton(r2b2);
        resetButton(r2b3);
        resetButton(r2b4);
        resetButton(r2b5);
        resetButton(r2b6);
        resetButton(r2b7);
        resetButton(r2b8);
        resetButton(r2b9);

        resetButton(r3b1);
        resetButton(r3b2);
        resetButton(r3b3);
        resetButton(r3b4);
        resetButton(r3b5);
        resetButton(r3b6);
        resetButton(r3b7);
        resetButton(r3b8);
        resetButton(r3b9);

        resetButton(r4b1);
        resetButton(r4b2);
        resetButton(r4b3);
        resetButton(r4b4);
        resetButton(r4b5);
        resetButton(r4b6);
        resetButton(r4b7);
        resetButton(r4b8);
        resetButton(r4b9);

        resetButton(r5b1);
        resetButton(r5b2);
        resetButton(r5b3);
        resetButton(r5b4);
        resetButton(r5b5);
        resetButton(r5b6);
        resetButton(r5b7);
        resetButton(r5b8);
        resetButton(r5b9);

        resetButton(r6b1);
        resetButton(r6b2);
        resetButton(r6b3);
        resetButton(r6b4);
        resetButton(r6b5);
        resetButton(r6b6);
        resetButton(r6b7);
        resetButton(r6b8);
        resetButton(r6b9);

        resetButton(r7b1);
        resetButton(r7b2);
        resetButton(r7b3);
        resetButton(r7b4);
        resetButton(r7b5);
        resetButton(r7b6);
        resetButton(r7b7);
        resetButton(r7b8);
        resetButton(r7b9);

        resetButton(r8b1);
        resetButton(r8b2);
        resetButton(r8b3);
        resetButton(r8b4);
        resetButton(r8b5);
        resetButton(r8b6);
        resetButton(r8b7);
        resetButton(r8b8);
        resetButton(r8b9);

        resetButton(r9b1);
        resetButton(r9b2);
        resetButton(r9b3);
        resetButton(r9b4);
        resetButton(r9b5);
        resetButton(r9b6);
        resetButton(r9b7);
        resetButton(r9b8);
        resetButton(r9b9);

    }

    @FXML
    private void togleFlag(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if (mineFlag) {
            mineFlag = false;
            btn.setStyle("-fx-background-color: #B9CDDA");
        } else {
            mineFlag = true;
            btn.setStyle("-fx-background-color: #00ff00");
        }

    }

    @FXML
    private void checkifmine(ActionEvent event) {
        if (!hasLost) {
            Button btn = (Button) event.getSource();

            int colum = 0;
            int row = 0;
            int valOfBox;

            switch (btn.getId()) {
                case "r1b1":
                    row = 1;
                    colum = 1;
                    break;
                case "r1b2":
                    row = 1;
                    colum = 2;
                    break;
                case "r1b3":
                    row = 1;
                    colum = 3;
                    break;
                case "r1b4":
                    row = 1;
                    colum = 4;
                    break;
                case "r1b5":
                    row = 1;
                    colum = 5;
                    break;
                case "r1b6":
                    row = 1;
                    colum = 6;
                    break;
                case "r1b7":
                    row = 1;
                    colum = 7;
                    break;
                case "r1b8":
                    row = 1;
                    colum = 8;
                    break;
                case "r1b9":
                    row = 1;
                    colum = 9;
                    break;
                //
                case "r2b1":
                    row = 2;
                    colum = 1;
                    break;
                case "r2b2":
                    row = 2;
                    colum = 2;
                    break;
                case "r2b3":
                    row = 2;
                    colum = 3;
                    break;
                case "r2b4":
                    row = 2;
                    colum = 4;
                    break;
                case "r2b5":
                    row = 2;
                    colum = 5;
                    break;
                case "r2b6":
                    row = 2;
                    colum = 6;
                    break;
                case "r2b7":
                    row = 2;
                    colum = 7;
                    break;
                case "r2b8":
                    row = 2;
                    colum = 8;
                    break;
                case "r2b9":
                    row = 2;
                    colum = 9;
                    break;

                //
                case "r3b1":
                    row = 3;
                    colum = 1;
                    break;
                case "r3b2":
                    row = 3;
                    colum = 2;
                    break;
                case "r3b3":
                    row = 3;
                    colum = 3;
                    break;
                case "r3b4":
                    row = 3;
                    colum = 4;
                    break;
                case "r3b5":
                    row = 3;
                    colum = 5;
                    break;
                case "r3b6":
                    row = 3;
                    colum = 6;
                    break;
                case "r3b7":
                    row = 3;
                    colum = 7;
                    break;
                case "r3b8":
                    row = 3;
                    colum = 8;
                    break;
                case "r3b9":
                    row = 3;
                    colum = 9;
                    break;

                //
                case "r4b1":
                    row = 4;
                    colum = 1;
                    break;
                case "r4b2":
                    row = 4;
                    colum = 2;
                    break;
                case "r4b3":
                    row = 4;
                    colum = 3;
                    break;
                case "r4b4":
                    row = 4;
                    colum = 4;
                    break;
                case "r4b5":
                    row = 4;
                    colum = 5;
                    break;
                case "r4b6":
                    row = 4;
                    colum = 6;
                    break;
                case "r4b7":
                    row = 4;
                    colum = 7;
                    break;
                case "r4b8":
                    row = 4;
                    colum = 8;
                    break;
                case "r4b9":
                    row = 4;
                    colum = 9;
                    break;

                //
                case "r5b1":
                    row = 5;
                    colum = 1;
                    break;
                case "r5b2":
                    row = 5;
                    colum = 2;
                    break;
                case "r5b3":
                    row = 5;
                    colum = 3;
                    break;
                case "r5b4":
                    row = 5;
                    colum = 4;
                    break;
                case "r5b5":
                    row = 5;
                    colum = 5;
                    break;
                case "r5b6":
                    row = 5;
                    colum = 6;
                    break;
                case "r5b7":
                    row = 5;
                    colum = 7;
                    break;
                case "r5b8":
                    row = 5;
                    colum = 8;
                    break;
                case "r5b9":
                    row = 5;
                    colum = 9;
                    break;

                //
                case "r6b1":
                    row = 6;
                    colum = 1;
                    break;
                case "r6b2":
                    row = 6;
                    colum = 2;
                    break;
                case "r6b3":
                    row = 6;
                    colum = 3;
                    break;
                case "r6b4":
                    row = 6;
                    colum = 4;
                    break;
                case "r6b5":
                    row = 6;
                    colum = 5;
                    break;
                case "r6b6":
                    row = 6;
                    colum = 6;
                    break;
                case "r6b7":
                    row = 6;
                    colum = 7;
                    break;
                case "r6b8":
                    row = 6;
                    colum = 8;
                    break;
                case "r6b9":
                    row = 6;
                    colum = 9;
                    break;

                //
                case "r7b1":
                    row = 7;
                    colum = 1;
                    break;
                case "r7b2":
                    row = 7;
                    colum = 2;
                    break;
                case "r7b3":
                    row = 7;
                    colum = 3;
                    break;
                case "r7b4":
                    row = 7;
                    colum = 4;
                    break;
                case "r7b5":
                    row = 7;
                    colum = 5;
                    break;
                case "r7b6":
                    row = 7;
                    colum = 6;
                    break;
                case "r7b7":
                    row = 7;
                    colum = 7;
                    break;
                case "r7b8":
                    row = 7;
                    colum = 8;
                    break;
                case "r7b9":
                    row = 7;
                    colum = 9;
                    break;

                //
                case "r8b1":
                    row = 8;
                    colum = 1;
                    break;
                case "r8b2":
                    row = 8;
                    colum = 2;
                    break;
                case "r8b3":
                    row = 8;
                    colum = 3;
                    break;
                case "r8b4":
                    row = 8;
                    colum = 4;
                    break;
                case "r8b5":
                    row = 8;
                    colum = 5;
                    break;
                case "r8b6":
                    row = 8;
                    colum = 6;
                    break;
                case "r8b7":
                    row = 8;
                    colum = 7;
                    break;
                case "r8b8":
                    row = 8;
                    colum = 8;
                    break;
                case "r8b9":
                    row = 8;
                    colum = 9;
                    break;

                //
                case "r9b1":
                    row = 9;
                    colum = 1;
                    break;
                case "r9b2":
                    row = 9;
                    colum = 2;
                    break;
                case "r9b3":
                    row = 9;
                    colum = 3;
                    break;
                case "r9b4":
                    row = 9;
                    colum = 4;
                    break;
                case "r9b5":
                    row = 9;
                    colum = 5;
                    break;
                case "r9b6":
                    row = 9;
                    colum = 6;
                    break;
                case "r9b7":
                    row = 9;
                    colum = 7;
                    break;
                case "r9b8":
                    row = 9;
                    colum = 8;
                    break;
                case "r9b9":
                    row = 9;
                    colum = 9;
                    break;
            }

            if (game.hasBeenOpened(row, colum) == 0) {

                valOfBox = game.checkBox(row, colum, mineFlag);
                //System.out.println(String.valueOf(valOfBox));
                if (valOfBox >= 0) {
                    btn.setText(String.valueOf(valOfBox));
                    if (mineFlag) {
                        btn.setStyle("-fx-background-color: #ff0000");
                    } else {
                        btn.setStyle("-fx-background-color: #8EAF9D");
                    }

                } else {
                    btn.setText("X");
                    if (mineFlag) {
                        btn.setStyle("-fx-background-color: #00ff00");
                        numberOfMines--;
                    } else {
                        btn.setStyle("-fx-background-color: #ff0000");
                    }
                }
            }
        }

        checkIfHasLost();
        updateScore();
    }
}
