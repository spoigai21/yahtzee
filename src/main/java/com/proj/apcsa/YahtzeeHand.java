package com.proj.apcsa;

import java.util.*;

public class YahtzeeHand {
    /**
     * Class YahtzeeHand is a single hand that creates and can
     * manipulate a set of Die objects
     * @author Shayan Poigai
     */

    private Die[] dice;

    public YahtzeeHand() {
        dice = new Die[5];
        for(int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
            dice[i].roll();
        }
    }



    /* Returns array of int with current values of the dice */
    public int[] getDice() {
        int[] dieValues = new int[dice.length];
        for (int i = 0; i < dieValues.length; i++) {
            dieValues[i] = dice[i].getValue();
        }
        return dieValues;
    }
    /* Rolls all dice */
    public void rollAll() {
        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
        }
    }
    /* Rolls specific dice */
    public void roll(int number) {
        dice[number - 1].roll();
    }
    /* Returns value of specified dice */
    public int get(int number) {
        return dice[number - 1].getValue();
    }
    /* Using console allow user to change dice by rolling two
     * more times, user can choose which dice to keep */
    public void changeHand() {
        ArrayList<Integer> keptValues = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int c = 0; c < 2; c++) {

            System.out.println("Enter die number(s) to keep (separated by a space):");
            String s = input.nextLine();

            for (int i = 0; i < s.length(); i++) {
                if (!(s.charAt(i) == ' ')) {
                    keptValues.add(Integer.parseInt(s.substring(i, i + 1)));
                }
            }

            for (int i = 1; i <= 5; i++) {
                if (!(keptValues.contains(i))){
                    roll(i);
                }
            }

            System.out.println(showDice());
        }

    }







    /* Returns string representing current state of the dice */
    public String showDice() {
        String s = "Dice | 1 | 2 | 3 | 4 | 5 |";
        s += "\n-----+---+---+---+---+---+";
        s+= "\nFace |";
        for (int i = 0; i < dice.length; i++) {
            s+= " " + dice[i].getValue() + " |";
        }
        return s;
    }
}
