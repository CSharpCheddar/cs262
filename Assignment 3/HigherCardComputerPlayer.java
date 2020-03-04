
/**
 * A concrete class which outlines everything needed to create an 
 * automated CardPlayer who plays Higher Card.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class HigherCardComputerPlayer extends HigherCardPlayer {
    private int roundsWon;
    //constructor passes all instance variables to the parent...
    //...and intitalizes all instance variables
    public HigherCardComputerPlayer(String name, int rounds) {
        super(name, rounds);
        roundsWon = 0;
    }
    //retrieves how many rounds this player has won
    public int getRoundsWon() {
        return roundsWon;
    }
    //updates how many rounds this player has won
    public void updateRoundsWon() {
        roundsWon++;
    }
    //adds a card to the hand held by this player
    public void dealCard(Card card) {
        hand.addCard(card);
    }
    //returns the card to be played from the hand held by this player
    public Card takeTurn() {
        return hand.drawNext();
    }
}
