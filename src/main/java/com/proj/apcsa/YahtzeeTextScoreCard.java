package com.proj.apcsa;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeTextScoreCard implements YahtzeeScoreCard {
    /**
     * Class YahtzeeTextScoreCard implements interface YahtzeeScoreCard
     * Contains an array of Strings that stores all the scores
     * Contains an ArrayList (type: Game) which keeps track of the number of games that are present
     * scoreHand uses scanner to prompt user to enter what number to score
     * changeScoreCard updates the array of scores
     * printScoreCard prints out the array
     * @author Shayan Poigai
     */

    private String[] scores;
    private ArrayList<Game> games = new ArrayList<>();

    private int totalScore;
    public YahtzeeTextScoreCard() {
        scores = new String[14];
        scores[0] = "1: 1s";
        scores[1] = "2: 2s";
        scores[2] = "3: 3s";
        scores[3] = "4: 4s";
        scores[4] = "5: 5s";
        scores[5] = "6: 6s";
        scores[6] = "7: Three Of A Kind";
        scores[7] = "8: Four Of A Kind";
        scores[8] = "9: Full House";
        scores[9] = "10: Small Straight";
        scores[10] = "11: Large Straight";
        scores[11]= "12: Chance";
        scores[12] = "13: Yahtzee";
        scores[13] = "14: Bonus Yahtzee";

    }
    private Game fetchGame(int game) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getGame() == game) {
                return games.get(i);
            }
        }
        Game g = new Game(game);
        games.add(g);
        return g;
    }

    @Override
    public void scoreHand(YahtzeeHand yahtzee, int game){
        Game g = fetchGame(game);
        g.addHand(yahtzee);
        Scanner input = new Scanner(System.in);
        YahtzeeScore score = new YahtzeeScore(yahtzee.getDice());

        System.out.println("Type the number of the box you want to check off");
        printScoreCard();
        int num = input.nextInt();
        while (scores[num - 1].contains("X")) {
            System.out.println("Please enter a number that has not been scored");
            System.out.println("Type the number of the box you want to check off");
            printScoreCard();
            num = input.nextInt();
        }
        int val = 0;
        switch (num) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                val = score.getUpperScore(num);
                break;
            case 7:
                val = score.scoreThreeOfAKind();
                break;
            case 8:
                val = score.scoreFourOfAKind();
                break;
            case 9:
                val = score.scoreFullHouse();
                break;
            case 10:
                val = score.scoreSmallStraight();
                break;
            case 11:
                val = score.scoreLargeStraight();
                break;
            case 12:
                val = score.scoreChance();
                break;
            case 13:
                val = score.scoreYahtzee();
                break;
            case 14:
                if (scores[12].contains("50"))
                    val = score.scoreBonusYahtzee();
                break;
            default:
                System.out.println("Enter a valid number");
                break;
        }

        increaseTotal(val);
        changeScoreCard(num, val);
    }

    /**
     * Precondition: num has to range from 1 to 14 (inclusive)
     * Postcondition: prints scorecard using array
     */
    private void changeScoreCard(int num, int val) {
        if (num < 10) {
            scores[num - 1] = "X" + scores[num - 1].substring(1);
        } else {
            scores[num - 1] = "X" + scores[num - 1].substring(2);
        }
        scores[num - 1] += " - " + val;
    }

    public void printScoreCard() {
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }

    private void increaseTotal(int val) {
        this.totalScore += val;
    }

    public int getTotal() {
        return this.totalScore;
    }

}

