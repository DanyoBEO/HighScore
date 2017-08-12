package com.example.danbe.highscore;

/**
 * Created by danbe on 6/30/2017.
 */

public class Player {
    private int mScore;
    //private String google_Id;
    private String mName;

    public Player(int score, String name){
        mScore = score;
        mName = name;

    }

    public int getScore(){
        return mScore;
    }

    public void setScore(int score){
        mScore = score;
    }

    public String getName(){
        return mName;
    }
}
