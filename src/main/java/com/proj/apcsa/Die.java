package com.proj.apcsa;

public class Die {
    /**
     * Class Die contains an instance variable dieValue and two methods
     * roll() and getValue()
     * @author Shayan Poigai
     */
    private int dieValue;

    public int roll() {
        dieValue = (int)(Math.random() * 6) + 1;
        return dieValue;
    }

    public int getValue() {
        return dieValue;
    }
}

