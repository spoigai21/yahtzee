package com.proj.apcsa;

public class Player {
    /**
     * Class Player represents a single player in this YahtzeeGame
     * @author Shayan Poigai
     */

    private int finalScore;

    private int wins = 0;

    private String name;

    public Player(String name) {
        finalScore = 0;
        this.name = name;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getFinalScore() {
        return this.finalScore;
    }

    public String getName() {
        return this.name;
    }

    public void incrementWins() {
        wins++;
    }

    public int getWins() {
        return wins;
    }

}
