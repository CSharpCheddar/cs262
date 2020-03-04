
/**
 * Outlines the basic functions needed for a card game.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public abstract class CardGame {
    CardPlayer players[]; //the card players playing the card game
    //initializes all instance variables
    public CardGame(CardPlayer[] players) {
        this.players = players;
    }
    /*
     * loops through all players while game is not over, having each
     * player take a turn until game is over, then uses getWinner to
     * display winner
     */
    public abstract void play();
    //check if game is over
    public abstract boolean isGameOver();
    //returns the winner(s)
    public abstract String getWinner();
}
