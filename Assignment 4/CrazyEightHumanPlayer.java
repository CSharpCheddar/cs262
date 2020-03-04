
/**
 * Defines a human player who plays a game of Crazy Eights.
 *
 * @author Martin Mueller
 * @version 04/29/2018
 */

import java.util.*;

public class CrazyEightHumanPlayer extends CrazyEightPlayer {
    //constructor for this class passes in a name and a hand size
    public CrazyEightHumanPlayer(String name, int handSize) {
        super(name, handSize);
    }
    //if the player takes the first turn of the game...
    public Card takeTurn() {
        //display current hand and prompt the user to input a card to play
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(name+"'s turn");
            System.out.println("Your current hand is:");
            System.out.print("["+hand.getCards().get(0));
            for(int i=1; i<hand.getCards().size(); i++) {
                System.out.print(", "+hand.getCards().get(i));
            }
            System.out.println("]");
            System.out.println("Which card do you want to play?");
            //read the user's input and make sure it's a valid card
            String input = scanner.next();
            //if the user entered nothing, they draw by default
            if(input.equals("none")) {
                return null;
            }
            Suit inputSuit = null;
            switch(input.substring(input.length()-1).toLowerCase()) {
                case "c":
                    inputSuit = Suit.CLUBS;
                    break;
                case "s":
                    inputSuit = Suit.SPADES;
                    break;
                case "h":
                    inputSuit = Suit.HEARTS;
                    break;
                case "d":
                    inputSuit = Suit.DIAMONDS;
                    break;
                default:
                    throw new InvalidCardException("Invalid suit");
            }
            int inputRank = Integer.parseInt(input.substring(0,input.length()-1));
            if(inputRank < 1 || inputRank > 13) {
                throw new InvalidCardException("Invalid rank");
            }
            //if the player has it in their hand, then play it
            ArrayList<Card> cards = hand.getCards();
            for(int i=0; i<cards.size(); i++) {
                if(cards.get(i).equals(new Card(inputSuit, inputRank))) {
                    return hand.draw(input);
                }
            }
            System.out.println("Invalid card. Try again");
        }
    }
    //prompts the player to take a turn and returns their choice of card
    public Card takeTurn(Suit suit, int rank) throws InvalidCardException {
        //display current hand and prompt the user to input a card to play
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(name+"'s turn");
            System.out.println("Your current hand is:");
            System.out.print("["+hand.getCards().get(0));
            for(int i=1; i<hand.getCards().size(); i++) {
                System.out.print(", "+hand.getCards().get(i));
            }
            System.out.println("]");
            System.out.println("Which card do you want to play?");
            //read the user's input and make sure it's a valid card
            String input = scanner.next();
            //if the user entered nothing, they draw by default
            if(input.equals("none")) {
                return null;
            }
            Suit inputSuit = null;
            switch(input.substring(input.length()-1).toLowerCase()) {
                case "c":
                    inputSuit = Suit.CLUBS;
                    break;
                case "s":
                    inputSuit = Suit.SPADES;
                    break;
                case "h":
                    inputSuit = Suit.HEARTS;
                    break;
                case "d":
                    inputSuit = Suit.DIAMONDS;
                    break;
                default:
                    throw new InvalidCardException("Invalid suit");
            }
            int inputRank = Integer.parseInt(input.substring(0,input.length()-1));
            if(inputRank < 1 || inputRank > 13) {
                throw new InvalidCardException("Invalid rank");
            }
            //if the card is playable and the player has it in their hand, then play it
            if(inputSuit.equals(suit) || inputRank == rank) {
                ArrayList<Card> cards = hand.getCards();
                Card card = new Card(inputSuit, inputRank);
                for(int i=0; i<cards.size(); i++) {
                    if(cards.get(i).equals(card)) {
                        return hand.draw(input);
                    }
                }
                System.out.println("You do not have that card");
            } else if(hand.getCards().contains(new Card(inputSuit, inputRank)) && inputRank == 8) { //this makes 8s always playable
                return hand.draw(input);
            } else {
                System.out.println("Invalid card. Try again");
            }
        }
    }
}
