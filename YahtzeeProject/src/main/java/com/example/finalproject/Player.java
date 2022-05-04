package com.example.finalproject;
import java.util.*;

public class Player {

    int[] dice = new int[5];
    ScoreCard score;
    int[] displayDice = new int[5];
    int tempDice[] = new int[5];
    public Player() {

        score = new ScoreCard();
    }



    public int[] rollDice() {
        int max = 5;
        int min = 1;
        Random random = new Random();
        for (int i = 0; i < dice.length; i++) {
            if (!isHeld(i)) {
                dice[i] = random.nextInt(max + min) + min;
            }
        }
            return dice;
        }
    public boolean isHeld(int i){
        if(displayDice[i]== 1000){
            return true;
        }
        return false;
    }
    public void holdDice(int die){
        if(displayDice[die] == 1000){
            displayDice[die] = 0;//returns held dice
        }else {
            displayDice[die] = 1000; //hold value to look for
        }
    }
    public void resetHolds(){
        for(int i = 0; i<dice.length; i++){
            displayDice[i] = 0;
        }
    }
    public int[] getDice(){
        return dice;
    }

    public ScoreCard getScoreCard() {
        return score;
    }

    public void addScore(int upperOrLower , int locationInArray){//Upper = 0 Lower = 1
        score.addInfo(upperOrLower, locationInArray);
    }
    public int[] checkScores(int die[]){
        int score[]  = new int[13];
        score[0] = num(1);
        score[1] = num(2);
        score[2] = num(3);
        score[3] = num(4);
        score[4] = num(5);
        score[5] = num(6);
        score[6] = ofKind(3);
        score[7] = ofKind(4);
        score[8] = fullHouse();
        score[9] = SmallStraight();
        score[10] = largeStraight();
        score[11] = Yahtzee();
        score[12] = Chance();
        return score;
    }

    public int num(int numToCheck){
        int dice[] = getDice();
        int score = 0;
        for(int i = 0; i<dice.length; i++){
            if(dice[i] == numToCheck){
                score+= dice[i];
            }
        }
        return score;
    }
    public int ofKind(int ofKind){
        int commons = 0;
        int total;
        for(int i = 0; i<dice.length; i++){
            total = 0;
            for(int numToFind = 1; numToFind<6; numToFind++){
                if(dice[i] == numToFind){
                    commons++;
                    total+= numToFind;
                }
                if(commons>= ofKind){
                    return total;
                }
            }
        }
        return 0;
    }
    public int fullHouse(){
        Arrays.sort(dice);
        if(dice[0]==dice[1] && dice[1]==dice[2]){
            if(dice[3]==dice[4]){
                return 25;
            }
        }
        if(dice[4]==dice[3] && dice[3]==dice[2]){
            if(dice[1]==dice[0]){
                return 25;
            }
        }
        return 0;

    }
    public int  Yahtzee(){
        int sameNum;
            sameNum = 0;
            for(int diceCount = 1; diceCount<6; diceCount++){
                for(int i = 0; i<dice.length; i++){
                if(dice[i] == diceCount){
                    sameNum++;
                    if(sameNum == 6){
                        return 50;
                    }
                }
            }
        }
            return 0;
    }
    public int Chance(){
        int total = 0;
        for(int i = 0; i<dice.length; i++){
            total+= dice[i];
        }
        return total;
    }

    public int SmallStraight() {
        int die[] = dice;
        Arrays.sort(die);
        int counter = 0;
        boolean found = false;
        Arrays.sort(die);

        for (int i = 0; i < die.length - 1; i++) {
            if (counter == 3) {
                found = true;
            }
            if (die[i + 1] == die[i] + 1) {
                counter++;
            } else if (die[i + 1] == die[i]) {
                continue;
            } else {
                counter = 0;
            }
        }
        if(found == true){
                return 30;
        }
        return 0;
    }
    public int largeStraight(){
        int die[] = dice;
        Arrays.sort(die);
        int counter = 0;
        boolean found = false;
        Arrays.sort(die);

        for (int i = 0; i < die.length - 1; i++) {
            if (counter == 4) {
                found = true;
            }
            if (die[i + 1] == die[i] + 1) {
                counter++;
            } else if (die[i + 1] == die[i]) {
                continue;
            } else {
                counter = 0;
            }
        }
        if(found == true){
            return 40;
        }
        return 0;
    }
}




