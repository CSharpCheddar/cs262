
/**
 * Runs a game of Higher Card.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */

import java.util.ArrayList;

public class HigherCardGame extends CardGame {
    protected Deck deck;
    private int rounds; //the number of rounds the game will go
    //passes necessary variables to the super class and...
    //...initializes all instance variables
    public HigherCardGame(CardPlayer players[], int rounds) {
        super(players);
        this.rounds = rounds;
        deck = new Deck();
    }
    /*
     * loops through all players while game is not over, having each
     * player take a turn until game is over, then uses getWinner to
     * display winner
     */
    public void play() {
        //shuffling the deck, then dealing out cards
        deck.shuffle();
        for(int i=0; i<rounds; i++) {
            for(CardPlayer player : players) {
                player.dealCard(deck.deal());
            }
        }
        //play out each round by iterating through the players' cards to see which is the highest...
        //...then update the winning player's score
        while(!isGameOver()) {
            //gather all cards in the trick
            Card trick[] = new Card[players.length];
            for(int i=0; i<players.length; i++) {
                trick[i] = players[i].takeTurn();
            }
            //compare all cards in the trick
            int winningCardNumber = 0;
            for(int i=1; i<trick.length; i++) {
                if(trick[i].compareTo(trick[winningCardNumber]) > 0) {
                    winningCardNumber = i;
                }
            }
            //award the trick to the winning player
            ((HigherCardPlayer)players[winningCardNumber]).updateRoundsWon();
            //subtract one from the total rounds remaining
            rounds--;
        }
        //print out the winner(s)
        System.out.println(getWinner());
    }
    //check if game is over
    public boolean isGameOver() {
        if(rounds == 0) {
            return true;
        }
        return false;
    }
    //returns the winner(s)
    public String getWinner() {
        String string = "Winner(s): ";
        //makes an ArrayList of all the players with the high score
        ArrayList<HigherCardComputerPlayer> winners = new ArrayList<>();
        winners.add((HigherCardComputerPlayer)players[0]);
        for(int i=1; i<players.length; i++) {
            if(winners.get(0).getRoundsWon() < ((HigherCardComputerPlayer)players[i]).getRoundsWon()) {
                winners.removeAll(winners);
                winners.add((HigherCardComputerPlayer)players[i]);
            } else if(winners.get(0).getRoundsWon() == ((HigherCardComputerPlayer)players[i]).getRoundsWon()) {
                winners.add((HigherCardComputerPlayer)players[i]);
            }
        }
        //iterates through the ArrayList and concatenates it with string
        string += winners.get(0).toString();
        for(int i=1; i<winners.size(); i++) {
            string += ", "+winners.get(i).toString();
        }
        //returns all the winners
        return string;
    }
}
