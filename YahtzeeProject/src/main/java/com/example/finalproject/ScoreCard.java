package com.example.finalproject;

public class ScoreCard{
    public int[] scoreCard = new int[13];

    public ScoreCard() {
        for(int i = 0; i<scoreCard.length; i++){
            scoreCard[i] = 999;
        }
    }

    public void addInfo(int locationInArray, int score){
            scoreCard[locationInArray] = score;
        }
    public int getScore(int index){
        return scoreCard[index];
    }
    public int[] getCard(){
        return scoreCard;
    }
    }

