package com.proj.apcsa;

import java.util.ArrayList;

public class Game {
    /**
     * Class Game represents a single game
     * A game stores 13 hand objects because 13 hands are created in a single game
     * These objects are stored in an ArrayList
     * The constructor initializes what game it is
     * addHand adds a YahtzeeHand to the ArrayList
     * getGame returns the game number
     * @author Shayan Poigai
     */

    private int game;

    private ArrayList<YahtzeeHand> hands = new ArrayList<>(13);

    public Game (int game) {
        this.game = game;
    }

    public void addHand(YahtzeeHand yahtzee) {
        hands.add(yahtzee);
    }

    public int getGame() {
        return game;
    }

}

