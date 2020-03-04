
/**
 * Defines a CardPlayer who plays the game Higher Card.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public abstract class HigherCardPlayer extends CardPlayer {
    protected Hand hand;
    private int rounds; //the number of rounds the player will play
    //initializes all instance variables except hand
    public HigherCardPlayer(String name, int rounds) {
        super(name);
        hand = new Hand(rounds);
        this.rounds = rounds;
    }
    //updates how many rounds this player has won
    public abstract void updateRoundsWon();
    //retrieves how many rounds this player has won
    public abstract int getRoundsWon();
}
