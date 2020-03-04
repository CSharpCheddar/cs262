
/**
 * Defines a hand of standard playing cards.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int size;
    //initializes the size of the hand
    public Hand(int m) {
        hand = new ArrayList<>();
        size = m;
    }
    //draws the next card from the hand
    public Card drawNext() throws DeckOrHandEmptyException {
        if(hand.size() == 0) {
            throw new DeckOrHandEmptyException("Hand is empty");
        }
        Card card = hand.get(0);
        hand.remove(0);
        return card;
    }
    //draws a specific card from hand
    //(in the format "8s", "1c", "11h", "13d", etc....)
    public Card draw(String s) throws InvalidCardException {
        //first it identifies the suit the player wants...
        Suit suit = null;
        switch(s.substring(s.length()-1).toLowerCase()) {
            case "s":
                suit = Suit.SPADES;
                break;
            case "c":
                suit = Suit.CLUBS;
                break;
            case "h":
                suit = Suit.HEARTS;
                break;
            case "d":
                suit = Suit.DIAMONDS;
                break;
            default:
                throw new InvalidCardException("Invalid suit");
        }
        //then it identifies the rank...
        int rank = Integer.parseInt(s.substring(0, s.length()-1));
        if(rank < 1 || rank > 13) {
            throw new InvalidCardException("Invalid rank");
        }
        //if this (valid) card is in the player's hand, it "draws" that card
        Card card = new Card(suit, rank);
        for(int i=0; i<hand.size(); i++) {
            if(hand.get(i).equals(card)) {
                hand.remove(i);
                i = hand.size();
            }
        }
        return card;
    }
    //adds a Card to hand
    public void addCard(Card c) {
        hand.add(c);
    }
    //gets the ArrayList of the Cards in hand
    public ArrayList<Card> getCards() {
        return hand;
    }
}
