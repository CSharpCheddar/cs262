
/**
 * Defines a basic AI that plays Crazy Eights.
 *
 * @author Martin Mueller
 * @version 04/29/2018
 */

import java.util.Random;

public class CrazyEightComputerPlayer extends CrazyEightPlayer {
    //constructor for this class, specifies the player's name and hand size
    public CrazyEightComputerPlayer(String name, int handSize) {
        super(name, handSize);
    }
    //if the AI plays the firsdt turn of the game...
    public Card takeTurn() {
        return hand.drawNext();
    }
    //forces the computer to take a turn
    public Card takeTurn(Suit suit, int rank) {
        System.out.println(name+"'s turn");
        //check for suit compatability
        for(int i=0; i<hand.getCards().size(); i++) {
            if(hand.getCards().get(i).getSuit().equals(suit)) {
                Card card = hand.getCards().get(i);
                switch(suit) {
                    case CLUBS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"c");
                    case SPADES:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"s");
                    case HEARTS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"h");
                    case DIAMONDS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"d");
                    default:
                        return null;
                }
            }
        }
        //check for rank compatability
        for(int i=0; i<hand.getCards().size(); i++) {
            if(hand.getCards().get(i).getRank() == rank) {
                Card card = hand.getCards().get(i);
                switch(suit) {
                    case CLUBS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"c");
                    case SPADES:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"s");
                    case HEARTS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"h");
                    case DIAMONDS:
                        System.out.println(name+" plays the "+card);
                        return hand.draw(rank+"d");
                    default:
                        return null;
                }
            }
        }
        //if nothing in the player's hand can be played, then return null
        System.out.println(name+" draws");
        return null;
    }
    //returns a random suit (for if the computer plays an eight)
    public static Suit getRandomSuit() {
        Random random = new Random();
        switch(random.nextInt(4)) {
            case 0:
                System.out.println("The leading suit is now clubs");
                return Suit.CLUBS;
            case 1:
                System.out.println("The leading suit is now spades");
                return Suit.SPADES;
            case 2:
                System.out.println("The leading suit is now hearts");
                return Suit.HEARTS;
            case 3:
                System.out.println("The leading suit is now diamonds");
                return Suit.DIAMONDS;
            default:
                return null;
        }
    }
}
