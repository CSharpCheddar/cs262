
/**
 * Defines a player of the card game Crazy Eights.
 *
 * @author Martin Mueller
 * @version 04/29/2018
 */

public abstract class CrazyEightPlayer extends CardPlayer {
    //the hand the player is dealt
    protected Hand hand;
    //passes in the name of the player to the parent class
    public CrazyEightPlayer(String name, int handSize) {
        super(name);
        hand = new Hand(handSize);
    }
    //adds a card to the player's hand
    @Override
    public void dealCard(Card card) {
        hand.addCard(card);
    }
    //returns the card the player plays for this round
    public abstract Card takeTurn(Suit suit, int rank);
    //handles if the player takes their first turn
    public abstract Card takeTurn();
    //determines if the player won
    public boolean isVictorious() {
        if(hand.getCards().size() == 0) {
            return true;
        }
        return false;
    }
}
