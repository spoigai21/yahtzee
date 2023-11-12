package com.proj.apcsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeMain {
    /**
     * Class YahtzeeMain contains a constant TOTAL_GAMES,
     * which represents the number of games that need to be run
     * play runs the game and each game lasts 13 rounds
     * playHand() uses class yahtzeeHand to pass in a hand object
     * The main method runs a whole single player Yahtzee game
     * @author Shayan Poigai
     */

    private static final int TOTAL_GAMES = 5;
    private static final int PLAYERS = 3;

    private Player maxPlayer(ArrayList<Player> players) {
        Player max = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (max.getFinalScore() < players.get(i).getFinalScore()) {
                max = players.get(i);
            }
        }
        return max;
    }

    private boolean tiesInGame(ArrayList<Player> players) {
        Player max = maxPlayer(players);

        for (int i = 1; i < players.size(); i++) {
            if (max.getFinalScore() == players.get(i).getFinalScore()) {
                return true;
            }
        }
        return false;
    }

    private Player returnWinner(ArrayList<Player> players) {
        Player winner = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            if (winner.getWins() < players.get(i).getWins()) {
                winner = players.get(i);
            }
        }

        return winner;
    }

    private boolean tiesInFullGame (ArrayList<Player> players) {
        Player max = returnWinner(players);

        for (int i = 1; i < players.size(); i++) {
            if (max.getWins() == players.get(i).getWins()) {
                return true;
            }
        }
        return false;
    }

    private void setAllPlayers(ArrayList<Player> players) {
        System.out.println("Enter player Information: ");
        Scanner input = new Scanner(System.in);
        for (int player = 0; player < PLAYERS; player++) {
        System.out.println("Please enter name for player " + (player + 1) + ": ");
        String name = input.nextLine();
        players.add(new Player(name));
        }

    }





    private void play() {

        YahtzeeTextScoreCard card;

        ArrayList<Player> players = new ArrayList<>(PLAYERS);

        setAllPlayers(players);

        for (int game = 0; game < TOTAL_GAMES; game++) {
            System.out.println("Game 1:");

            card = new YahtzeeTextScoreCard();

            for (int player = 0; player < PLAYERS; player++) {

                card = new YahtzeeTextScoreCard();

                System.out.println(players.get(player).getName() + "'s Turn: ");

            for (int i = 1; i <= 13; i++) {

                card.scoreHand(playHand(), game);

                if (i == 13) {
                    card.printScoreCard();
                    System.out.println(players.get(player).getName() + "'s Total Score: " + card.getTotal());
                    players.get(player).setFinalScore(card.getTotal());
                    }

                }

            }

            if (!tiesInGame(players)) {
            System.out.println("Winner of game " + (game + 1) + ": " + maxPlayer(players).getName());
            maxPlayer(players).incrementWins();
            } else {
                System.out.println("Game has been tied, running game again...");
                game -= 1;
            }

            System.out.println("\nCongratulations on completing game " + (game + 1));

        }

            for (int player = 0; player < players.size(); player++) {
                System.out.println(players.get(player).getName() + " number of wins: " + players.get(player).getWins());
            }

            if (!tiesInFullGame(players)) {
            System.out.println("Overall Winner: " + returnWinner(players));
            } else {
                System.out.println("Game has been tied...");
            }

    }

    private YahtzeeHand playHand() {
        YahtzeeHand yahtzee = new YahtzeeHand();
        System.out.println(yahtzee.showDice());
        yahtzee.changeHand();
        System.out.println("Final dice: "
                + Arrays.toString(yahtzee.getDice()));
        return yahtzee;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to roll your die or 0 to quit.");
        int roll = input.nextInt();
        while (roll != 0) {

            YahtzeeMain m = new YahtzeeMain();

            m.play();

            System.out.println("Enter 1 to roll your die or 0 to quit.");
            roll = input.nextInt();
        }
        System.out.println("Thank you!");
    }



}
