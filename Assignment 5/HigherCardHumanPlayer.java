
/**
 * Defines a card player that plays the game Higher Card. 
 * A human user is able to control this type of player.
 *
 * @author Martin Mueller
 * @version 05/07/2018
 */
public class HigherCardHumanPlayer extends HigherCardPlayer {
    private int roundsWon;//how many rounds the player has won
    //initializes all instance variables
    public HigherCardHumanPlayer(String name, int rounds) {
        super(name, rounds);
        roundsWon = 0;
    }
    //gets the number of rounds the player has won so far
    public int getRoundsWon() {
        return roundsWon;
    }
    //adds 1 to the number of rounds the player has won
    public void updateRoundsWon() {
        roundsWon++;
    }
    //adds a card to the player's hand
    public void dealCard(Card card) {
        hand.addCard(card);
    }
    //returns the card which the user wishes to play
    public Card takeTurn() {
        return null; //placeholder for now...
    }
}
