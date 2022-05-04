package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.util.Scanner;

import java.lang.*;

public class HelloController {

    Player one;
    Player two;
    public int playerTurn = 2;
    public int rolltimes = 0;
    public Button oneButtons[];
    public Button twoButtons[];
    public boolean upFull=false;
    public boolean upFullTwo = false;
    public boolean lowerFull =false;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label diceOne;
    @FXML
    private Label diceTwo;
    @FXML
    private Label diceThree;
    @FXML
    private Label diceFour;
    @FXML
    private Label diceFive;
    @FXML
    private Label output;
    @FXML
    private Button acesScoreOne;
    @FXML
    private Button twosScoreOne;
    @FXML
    private Button threesScoreOne;
    @FXML
    private Button foursScoreOne;
    @FXML
    private Button fivesScoreOne;
    @FXML
    private Button sixesScoreOne;
    @FXML
    private Button threeKindScoreOne;
    @FXML
    private Button fourKindScoreOne;
    @FXML
    private Button fullHouseScoreOne;
    @FXML
    private Button smallStraightScoreOne;
    @FXML
    private Button largeStraightScoreOne;
    @FXML
    private Button yahtzeeScoreOne;
    @FXML
    private Button chanceScoreOne;
    @FXML
    private Button acesScoreTwo;
    @FXML
    private Button twosScoreTwo;
    @FXML
    private Button threesScoreTwo;
    @FXML
    private Button foursScoreTwo;
    @FXML
    private Button fivesScoreTwo;
    @FXML
    private Button sixesScoreTwo;
    @FXML
    private Button threeKindScoreTwo;
    @FXML
    private Button fourKindScoreTwo;
    @FXML
    private Button fullHouseScoreTwo;
    @FXML
    private Button smallStraightScoreTwo;
    @FXML
    private Button largeStraightScoreTwo;
    @FXML
    private Button yahtzeeScoreTwo;
    @FXML
    private Button chanceScoreTwo;
    @FXML
    private Label upperScoreSumOne;
    @FXML
    private Label upperScoreSumTwo;
    @FXML
    private Label bonusOne;
    @FXML
    private Label bonusTwo;
    @FXML
    private Label lowerScoreSumOne;
    @FXML
    private Label lowerScoreSumTwo;
    @FXML
    private Label finalScoreOne;
    @FXML
    private Label finalScoreTwo;
    @FXML
    private Button rollDice;
    @FXML
    public Label playersInd;


    @FXML
    public void onNew(ActionEvent actionEvent) {
        createButtonArray();
        one = new Player();
        two = new Player();
        comboBox.getItems().clear();
        comboBox.getItems().addAll("Dice 1", "Dice 2", "Dice 3", "Dice 4", "Dice 5");
        clearAllButtons();
        playerTurn = 2;
        rolltimes = 0;
        rollDice.setDisable((false));
        output.setText("New Game Started! Player Ones Turn, press roll to begin");

    }
    public void clearAllButtons(){
        for(int i = 0; i< oneButtons.length; i++){
            oneButtons[i].setText("");
            oneButtons[i].setDisable(false);
            twoButtons[i].setText("");
            twoButtons[i].setDisable(false);
        }
    }
    public void createButtonArray() {
        oneButtons = new Button[13];
        twoButtons = new Button[13];
        oneButtons[0] = acesScoreOne;
        oneButtons[1] = twosScoreOne;
        oneButtons[2] = threesScoreOne;
        oneButtons[3] = foursScoreOne;
        oneButtons[4] = fivesScoreOne;
        oneButtons[5] = sixesScoreOne;
        oneButtons[6] = threeKindScoreOne;
        oneButtons[7] = fourKindScoreOne;
        oneButtons[8] = fullHouseScoreOne;
        oneButtons[9] = smallStraightScoreOne;
        oneButtons[10] = largeStraightScoreOne;
        oneButtons[11] = yahtzeeScoreOne;
        oneButtons[12] = chanceScoreOne;
        twoButtons[0] = acesScoreTwo;
        twoButtons[1] = twosScoreTwo;
        twoButtons[2] = threesScoreTwo;
        twoButtons[3] = foursScoreTwo;
        twoButtons[4] = fivesScoreTwo;
        twoButtons[5] = sixesScoreTwo;
        twoButtons[6] = threeKindScoreTwo;
        twoButtons[7] = fourKindScoreTwo;
        twoButtons[8] = fullHouseScoreTwo;
        twoButtons[9] = smallStraightScoreTwo;
        twoButtons[10] = largeStraightScoreTwo;
        twoButtons[11] = yahtzeeScoreTwo;
        twoButtons[12] = chanceScoreTwo;

    }


    @FXML
    public void onRoll(ActionEvent actionEvent) {
        int turn = checkTurn();
        if (turn == 1) {
            if (rolltimes < 3) {
                int dice[] = one.rollDice();
                updateDice(dice);
                int tempScores[] = one.checkScores(dice);
                updateScorecard(1, tempScores);
                rolltimes++;
            }
            else{
                output.setText("You've hit max rolls");
                rollDice.setDisable(true);
            }
        } else {
            if (rolltimes < 3) {
                int diceTwo[] = two.rollDice();
                updateDice(diceTwo);
                int tempScoresTwo[] = two.checkScores(diceTwo);
                updateScorecard(2, tempScoresTwo);
                rolltimes++;
            } else{
                output.setText("You've hit max rolls");
                rollDice.setDisable(true);
            }

        }
    }
    @FXML
    public void onHold(ActionEvent actionEvent) {
        String diceHeld;
        while (true) {
            try {
                diceHeld = comboBox.getValue().toString();
                if (diceHeld != null) {
                    break;
                }
            } catch (NullPointerException e) {
                output.setText("Select which dice to hold/return");
            }
        }
        switch (diceHeld) {
            case "Dice 1":
                if (checkTurn() == 1) {
                    one.holdDice(0);
                } else {
                    two.holdDice(0);
                }
                break;
            case "Dice 2":
                if (checkTurn() == 1) {
                    one.holdDice(1);
                } else {
                    two.holdDice(1);
                }

                break;
            case "Dice 3":
                if (checkTurn() == 1) {
                    one.holdDice(2);
                } else {
                    two.holdDice(2);
                }

                break;
            case "Dice 4":
                if (checkTurn() == 1) {
                    one.holdDice(3);
                } else {
                    two.holdDice(3);
                }
                break;
            case "Dice 5":
                if (checkTurn() == 1) {
                    one.holdDice(4);
                } else {
                    two.holdDice(4);
                }
                break;
        }
    }

    public void endTurn() {
        if (checkTurn() == 1) {
                rolltimes = 0;
                disablePlayer(1);
                enablePlayer(2);
                erasePlayerTwo();
                two.resetHolds();
                rollDice.setDisable(false);
                playersInd.setText("Player Two Turn");
                output.setText("");
        } else {
            rolltimes = 0;
            disablePlayer(2);
            enablePlayer(1);
            erasePlayerOne();
            one.resetHolds();
            rollDice.setDisable(false);
            playersInd.setText("Player Ones Turn");
            output.setText("");
        }
            if (checkUpper(1) && checkUpper(2)){
                upFull = true;
            }
            if(checkLower()){
                lowerFull = true;
            }
        if(upFull && lowerFull) {
                endGamer();
        }
        playerTurn++;
    }
    public void disablePlayer(int player) {
        if (player == 1) {
            for (int i = 0; i < oneButtons.length; i++) {
                oneButtons[i].setDisable(true);
                if (one.getScoreCard().getScore(i) == 999) {
                    oneButtons[i].setText("");
                }
            }
        } else {
            for (int i = 0; i < twoButtons.length; i++) {
                twoButtons[i].setDisable(true);
                if (two.getScoreCard().getScore(i) == 999) {
                    twoButtons[i].setText("");
                }
            }
        }
    }
    public void enablePlayer(int player){
            if (player == 1) {
                for (int i = 0; i < oneButtons.length; i++) {
                    if (one.getScoreCard().getScore(i) == 999) {
                        oneButtons[i].setDisable(false);
                        oneButtons[i].setText("");
                    }
                }
            } else {
                for (int i = 0; i < twoButtons.length; i++) {
                    if (two.getScoreCard().getScore(i) == 999) {
                        twoButtons[i].setDisable(false);
                        twoButtons[i].setText("");
                    }
                }
            }
        }

    private void updateDice(int[] dice) {
        diceOne.setText(String.valueOf(dice[0]));
        diceTwo.setText(String.valueOf(dice[1]));
        diceThree.setText(String.valueOf(dice[2]));
        diceFour.setText(String.valueOf(dice[3]));
        diceFive.setText(String.valueOf(dice[4]));
    }

    public void updateScorecard(int player, int scores[]) {
        int fillNums[] = new int[13];
        int fillNumsTwo[] = new int[13];
        if (player == 1) {
            for (int i = 0; i < 13; i++) {
                if (one.getScoreCard().getScore(i) == 999) {
                    fillNums[i] = scores[i];
                } else {
                    fillNums[i] = one.getScoreCard().getScore(i);
                }
                fillPlayer(1, fillNums);
            }
        } else if (player == 2) {
            for (int i = 0; i < 13; i++) {
                if (two.getScoreCard().getScore(i) == 999) {
                    fillNumsTwo[i] = scores[i];
                } else {
                    fillNumsTwo[i] = two.getScoreCard().getScore(i);
                }
                fillPlayer(2, fillNumsTwo);
            }
        }
    }

    public void fillPlayer(int player, int numsToFill[]) {
        if (player == 1) {
            for (int i = 0; i < oneButtons.length; i++) {
                oneButtons[i].setText(String.valueOf(numsToFill[i]));
            }
        } else {
            for (int i = 0; i < twoButtons.length; i++) {
                twoButtons[i].setText(String.valueOf(numsToFill[i]));
            }
        }
    }

    public void erasePlayerOne() {
        for (int i = 0; i < oneButtons.length; i++) {
            if (!oneButtons[i].isDisabled()) {
                oneButtons[i].setText("");
            }
        }
    }

    public void erasePlayerTwo() {
        for (int i = 0; i < twoButtons.length; i++) {
            if (!twoButtons[i].isDisabled()) {
                twoButtons[i].setText("");
            }
        }
    }



    public boolean checkUpper(int player) {
        int numsInPlayerOne = 0;
        int numsInPlayerTwo = 0;
        boolean playerOne = true;
        boolean playerTwo = true;
        if (player == 1) {
            for (int i = 0; i < 6; i++) {
                if (one.getScoreCard().getScore(i) == 999) {
                    return false;
                } else {
                    numsInPlayerOne += one.getScoreCard().getScore(i);
                }
            }
            upperScoreSumOne.setText(String.valueOf(numsInPlayerOne));
            if (playerOne) {
                return true;
            }
            if(checkBonus(1)){
                bonusOne.setText("35");
            }else{
                bonusOne.setText("0");
            }
        } else {
            for (int i = 0; i < 6; i++) {
                if (two.getScoreCard().getScore(i) == 999) {
                    return false;
                } else {
                    numsInPlayerTwo += two.getScoreCard().getScore(i);
                }
            }
            upperScoreSumTwo.setText(String.valueOf(numsInPlayerTwo));
            if (playerTwo) {
                return true;
            }
            if(checkBonus(2)){
                bonusTwo.setText("35");
            }else{
                bonusTwo.setText("0");
            }
        }

        return false;
    }

    public boolean checkBonus(int player){
        int total = 0;
        if(player==1){
            for(int i = 0; i<6; i++) {
                if (one.getScoreCard().getScore(i) != 999) {
                    total += one.getScoreCard().getScore(i);
                }
                if (total > 63) {
                    return true;
                }
            }
        }else{
            for(int i = 0; i<6; i++){
                if (two.getScoreCard().getScore(i) != 999) {
                    total += two.getScoreCard().getScore(i);
                }
            }
            if(total>63){
                return true;
            }
        }
        return false;
    }




    public boolean checkLower() {
        int oneTotal = 0;
        int twoTotal = 0;
        boolean oneFull = false;
        boolean twoFull = false;
        for (int i = 6; i < one.getScoreCard().getCard().length; i++) {
            if (one.getScoreCard().getScore(i) == 999) {
                return false;
            } else {
                oneTotal += one.getScoreCard().getScore(i);
                oneFull = true;
            }
            if (two.getScoreCard().getScore(i) == 999) {
                return false;
            } else {
                twoTotal += two.getScoreCard().getScore(i);
                twoFull = true;
            }
            if (oneFull) {
                lowerScoreSumOne.setText(String.valueOf(oneTotal));
            }
            if (twoFull) {
                lowerScoreSumTwo.setText(String.valueOf(twoTotal));
            }
        }
            return oneFull & twoFull;
    }

    public int checkTurn() {
        if (playerTurn % 2 == 0) {
            return 1;
        }
        return 2;
    }

    public void endGamer() {
        int playerOneTotal = 0;
        int playerTwoTotal = 0;
        for (int i = 0; i < 13; i++) {
            playerOneTotal += one.getScoreCard().getScore(i);
            playerTwoTotal += two.getScoreCard().getScore(i);
        }
        if (checkBonus(1)) {
            playerOneTotal += 35;
        }
        if (checkBonus(2)) {
            playerTwoTotal += 35;
        }
        finalScoreOne.setText(String.valueOf(playerOneTotal));
        finalScoreTwo.setText(String.valueOf(playerTwoTotal));
        if (playerOneTotal > playerTwoTotal) {
            output.setText("Player one wins!");
        } else if (playerTwoTotal == playerOneTotal) {
            output.setText("Tie game!");
        } else {
            output.setText("Player two wins");
        }
    }

    @FXML
    public void acesPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(0, scores[0]);
        acesScoreOne.setDisable(true);
        endTurn();

    }

    @FXML
    public void twosPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(1, scores[1]);
        twosScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void threesPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(2, scores[2]);
        threesScoreOne.setDisable(true);
        endTurn();

    }

    @FXML
    public void foursPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(3, scores[3]);
        foursScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void fivesPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(4, scores[4]);
        fivesScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void sixesPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(5, scores[5]);
        sixesScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void threeKindPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(6, scores[6]);
        threeKindScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void fourKindPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(7, scores[7]);
        fourKindScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void fullHousePressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(8, scores[8]);
        fullHouseScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void smallStraightPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(9, scores[9]);
        smallStraightScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void largeStraightPressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(10, scores[10]);
        largeStraightScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void yahtzeePressed(ActionEvent actionEvent) {
        int scores[] = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(11, scores[11]);
        yahtzeeScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void chancePressed(ActionEvent actionEvent) {
        int[] scores = one.checkScores(one.getDice());
        one.getScoreCard().addInfo(12, scores[12]);
        chanceScoreOne.setDisable(true);
        endTurn();
    }


    @FXML
    public void acesPressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(0, scores[0]);
        acesScoreOne.setDisable(true);
        endTurn();
    }

    @FXML
    public void twosPressedTwo(ActionEvent actionEvent) {
        int[] scores = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(1, scores[1]);
        twosScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void threesPressedTwo(ActionEvent actionEvent) {
        int[] scores = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(2, scores[2]);
        threesScoreTwo.setDisable(true);
        endTurn();
    }


    @FXML
    public void foursPressedTwo(ActionEvent actionEvent) {
        int[] scores = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(3, scores[3]);
        foursScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void fivesPressedTwo(ActionEvent actionEvent) {
        int[] scores = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(4, scores[4]);
        fivesScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void sixesPressedTwo(ActionEvent actionEvent) {
        int[] scores = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(5, scores[5]);
        sixesScoreTwo.setDisable(true);
        endTurn();
    }


    @FXML
    public void threeKindPressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(6, scores[6]);
        threeKindScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void fourKindPressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(7, scores[7]);
        fourKindScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void smallStraightPressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(9, scores[9]);
        smallStraightScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void largeStraightPressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(10, scores[10]);
        largeStraightScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void fullHousePressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(8, scores[8]);
        fullHouseScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void yahtzeePressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(11, scores[11]);
        yahtzeeScoreTwo.setDisable(true);
        endTurn();
    }

    @FXML
    public void chancePressedTwo(ActionEvent actionEvent) {
        int scores[] = two.checkScores(two.getDice());
        two.getScoreCard().addInfo(12, scores[12]);
        chanceScoreTwo.setDisable(true);
        endTurn();
    }
}