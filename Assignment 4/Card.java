
/**
 * Defines a card that could be found in a standard playing card deck.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class Card implements Comparable<Card> {
    private Suit suit; //the card's suit
    private int rank; //the card's rank
    //contructor initializes all instance variables
    public Card(Suit suit, int rank) throws InvalidCardException {
        this.suit = suit;
        if(rank < 1 || rank > 13) {
            throw new InvalidCardException("Rank out of bounds");
        } else { 
            this.rank = rank;
        }
    }
    //determines if two cards are the same card
    public boolean equals(Card card) {
        if(card.getSuit().equals(getSuit()) && card.getRank() == getRank()) {
            return true;
        }
        return false;
    }
    //converts the class to a string when this method is called or the object is printed
    @Override
    public String toString() {
        String string = "";
        //first identifies the rank of the card
        if(getRank() == 1) {
            string += "Ace of ";
        } else if(getRank() >= 2 && getRank() <= 10) {
            string += getRank()+" of ";
        } else if(getRank() == 11) {
            string += "Jack of ";
        } else if(getRank() == 12) {
            string += "Queen of ";
        } else {
            string += "King of ";
        }
        //then it identifies the suit
        switch(getSuit()) {
            case SPADES:
                string += "Spades";
                break;
            case HEARTS:
                string += "Hearts";
                break;
            case DIAMONDS:
                string += "Diamonds";
                break;
            case CLUBS:
                string += "Clubs";
                break;
        }
        return string;
    }
    //compares this Card with another
    @Override
    public int compareTo(Card card) {
        //this first attempts to compare the cards by suit...
        if(!getSuit().equals(card.getSuit())) {
            switch(card.getSuit()) {
                case SPADES:
                    return -1;
                case HEARTS:
                    if(getSuit().equals(Suit.SPADES)) {
                        return 1;
                    }
                    return -1;
                case DIAMONDS:
                    if(getSuit().equals(Suit.SPADES) || getSuit().equals(Suit.HEARTS)) {
                        return 1;
                    }
                    return -1;
                case CLUBS:
                    return 1;
            }
        } else { //...then it attemps to compare the card by rank
            if(card.getRank() > getRank()) {
                return -1;
            } else if(card.getRank() < getRank()) {
                return 1;
            }
        }
        //if everything is equal, returns 0
        return 0;
    }
    //returns the card's rank (Ace-King)
    public int getRank() {
        return rank;
    }
    //returns the cards suit (e.g. clubs)
    public Suit getSuit() {
        return suit;
    }
}
