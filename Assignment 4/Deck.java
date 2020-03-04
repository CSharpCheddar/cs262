
/**
 * Stores properties of a standard deck of playing cards.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */

import java.util.*;

public class Deck {
    private ArrayList<Card> deck; //the cards currently in the deck
    //the constructor populates the deck with Cards in new deck order
    public Deck() {
        deck = new ArrayList<>();
        for(int i=1; i<=4; i++) {
            for(int j=1; j<=13; j++) {
                if(i == 1) {
                    deck.add(new Card(Suit.HEARTS, j));
                } else if(i == 2) {
                    deck.add(new Card(Suit.CLUBS, j));
                } else if(i == 3) {
                    deck.add(new Card(Suit.DIAMONDS, 14-j));
                } else {
                    deck.add(new Card(Suit.SPADES, 14-j));
                }
            }
        }
    }
    //creates a new deck with the given ArrayList of Cards
    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    //converts the deck into a string when called or when the object is printed
    @Override
    public String toString() {
        String string = "";
        for(int i=0; i<deck.size(); i++) {
            if(i != deck.size()-1) {
                string += deck.get(i).toString()+", ";
            } else {
                string += deck.get(i).toString();
            }
        }
        return string;
    }
    //returns true if the deck is empty, else false
    public boolean isDeckEmpty() {
        if(deck.size() == 0) {
            return true;
        }
        return false;
    }
    //deals the topmost card in the deck
    public Card deal() throws DeckOrHandEmptyException {
        if(isDeckEmpty()) {
            throw new DeckOrHandEmptyException("The deck is empty");
        }
        Card topCard = deck.get(0);
        deck.remove(0);
        return topCard;
    }
    //shuffles the cards in the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }
}
