
/**
 * Outlines the basic elements of a card player.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public abstract class CardPlayer {
    String name; //the card player's name
    //the constructor initializes all instance variables
    public CardPlayer(String name) {
        this.name = name;
    }
    //converts this Player object into a string if called...
    //...or if the Player is printed
    public String toString() {
        return name;
    }
    //returns the card to be played from the hand held by this player
    public abstract Card takeTurn();
    //adds a card to the hand held by this player
    public abstract void dealCard(Card card);
}
