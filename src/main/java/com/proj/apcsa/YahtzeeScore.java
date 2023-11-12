package com.proj.apcsa;


/* Starter file for JHU CTY AP CS Course Final Project
 * Initial code for YahtzeeScore with stub implementations
 */

public class YahtzeeScore {
    /**
     * Class YahtzeeScore contains methods that contain algorithms
     * to calculate the score based on a set of Die values
     * @author Shayan Poigai
     */

    private int[] dice;
    /* Constructor, parameter dice contains values of dice to be scored
     * */
    public YahtzeeScore(int[] dice) {
        this.dice = new int[dice.length];
        for (int i = 0; i < dice.length; i++)
            this.dice[i] = dice[i];
    }

    /* For a given hand calculate the lower score; if value is 1 score ones, etc. */
    public int getUpperScore(int value) {
        int sum = 0;
        for (int i : dice) {
            if (i == value)
                sum += i;
        }
        return sum;
    }
    public int scoreThreeOfAKind() {
        int sum;
        int counter = 0;
        int max = 0;
        int target = 0;
        for (int i = 0; i < dice.length; i++) {
            target = dice[i];
            for (int c = 0; c < dice.length; c++) {
                if (target == dice[c]) {
                    counter++;
                }

                if (counter > max) {
                    max = counter;
                }

                if (max == 3) {
                    sum = scoreChance();
                    return sum;
                }
            }
            counter = 0;
        }


        return 0;
    }

    public int scoreFourOfAKind() {
        int sum;
        int counter = 0;
        int max = 0;
        int target = 0;
        for (int i = 0; i < dice.length; i++) {

            target = dice[i];
            for (int c = 0; c < dice.length; c++) {
                if (target == dice[c]) {
                    counter++;
                }
                if (counter > max) {
                    max = counter;
                }
                if (max == 4) {
                    sum = scoreChance();
                    return sum;
                }
            }
            counter = 0;
        }
        return 0;

    }

    //fix
    public int scoreFullHouse() {

        if(scoreThreeOfAKind() == 0 || scoreFourOfAKind() != 0) {
            return 0;
        }

        int count = 0;
        int target1 = dice[0];
        int target2 = 0;

        for (int i = 1; i < dice.length; i++) {
            if (target1 != dice[i] && target2 == 0) {
                target2 = dice[i];
                count++;
                continue;
            }

            if (target2 == dice[i]) {
                count++;
            }
        }
        if (count >= 2)
            return 25;

        return 0;
    }

    public int scoreSmallStraight() {
        int min = Integer.MAX_VALUE;

        // finds minimum value
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] < min) {
                min = dice[i];
            }
        }

        int counter = 1;
        min++;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == min) {
                min++;
                counter++;
                i = -1;
            }
        }

        if (counter >= 4) {
            return 30;
        }


        return 0;
    }

    public int scoreLargeStraight() {
        int min = Integer.MAX_VALUE;

        if (scoreSmallStraight() == 0)
            return 0;

        // finds minimum value
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] < min) {
                min = dice[i];
            }
        }

        int counter = 0;

        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == min) {
                min++;
                counter++;
                i = -1;
            }
        }

        if (counter >= 4) {
            return 40;
        }


        return 0;
    }


    public int scoreChance() {
        int sum = 0;
        for (int d : dice)
            sum += d;
        return sum;
    }


    public int scoreYahtzee() {
        int value = dice[0];

        for (int i = 1; i < dice.length; i++) {
            if (value != dice[i])
                return 0;
        }



        return 50;
    }

    public int scoreBonusYahtzee() {
        int value = dice[0];

        for (int i = 1; i < dice.length; i++) {
            if (value != dice[i])
                return 0;
        }

        return 100;
    }
}
