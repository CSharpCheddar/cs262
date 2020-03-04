
/**
 * Creates a game of Crazy Eights
 *
 * @author Martin Mueller
 * @version 04/29/2018
 */

import java.util.*;

public class CrazyEightGame extends CardGame {
    private Deck deck; //stores draw pile/place where cards are dealt from
    private ArrayList<Card> discardPile; //stores the cards played so far
    private Suit leadingSuit; //keeps track of the current suit the player must play
    private int handSize; //specifiies the size of players' hands of cards
    private int movesMade = 1; //keeps track of the moves made per turn
    //constructor initializes instance variables
    public CrazyEightGame(CardPlayer players[], int handSize) {
        super(players);
        this.handSize = handSize;
        deck = new Deck();
        discardPile = new ArrayList<Card>(); //makes an empty discard pile
    }

    public void play() {
        //shuffle deck and deal cards
        deck.shuffle();
        for(int i=0; i<handSize; i++) {
            for(CardPlayer player : players) {
                player.dealCard(deck.deal());
            }
        }
        //while the game isn't over, run this...
        while(!isGameOver()) {
            movesMade = 0;
            //if it's the first round of the game...
            if(discardPile.size() == 0) {
                discardPile.add(deck.deal());
                leadingSuit = discardPile.get(0).getSuit();
                System.out.println("The seed card is the "+discardPile.get(0));
            } else {
                //iterate through the players
                for(int i=0; i<players.length; i++) {
                    //get the card they played
                    Card play = ((CrazyEightPlayer)players[i]).takeTurn(leadingSuit, discardPile.get(discardPile.size()-1).getRank());
                    if(play != null) { //if they played something, adjust current suit and rank and put it in the discard pile
                        if(play.getRank() == 8) {
                            leadingSuit = adjustSuit(players[i]);
                        } else {
                            leadingSuit = play.getSuit();
                        }
                        discardPile.add(play);
                        movesMade++;
                    } else { //if they played nothing, have them draw a card
                        if(deck.isDeckEmpty()) { //if the draw pile is empty, refill it
                            ArrayList<Card> newDeck = new ArrayList<Card>();
                            for(int j=discardPile.size()-2; j>=0; j--) {
                                newDeck.add(discardPile.get(j));
                                discardPile.remove(j);
                            }
                            Collections.shuffle(newDeck);
                            deck = new Deck(newDeck);
                        }
                        ((CrazyEightPlayer)players[i]).dealCard(deck.deal());
                    }
                    //if the player is victorious, break out of the loop so the game can end immediately
                    if(((CrazyEightPlayer)players[i]).isVictorious()) {
                        i = players.length;
                    }
                }
            }
        }
    }
    //if the player played an eight, this method is called to adjust the current "acceptable" suit
    public Suit adjustSuit(CardPlayer player) {
        if(player instanceof CrazyEightComputerPlayer) { //if it's a computer, get a random suit
            return CrazyEightComputerPlayer.getRandomSuit();
        } else { //if it's a player, prompt them for a VALID suit
            boolean isValidInput = false;
            while(!isValidInput) {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Which suit would you like to change to?");
                switch(scanner.next().toLowerCase()) {
                    case "clubs":
                        return Suit.CLUBS;
                    case "spades":
                        return Suit.SPADES;
                    case "hearts":
                        return Suit.HEARTS;
                    case "diamonds":
                        return Suit.DIAMONDS;
                    default:
                        System.out.println("Invalid suit choice");
                        isValidInput = false;
                }
            }
        }
        return null;
    }
    //gets the name of the winner of the game
    public String getWinner() {
        for(CardPlayer player : players) {
            if(((CrazyEightPlayer)player).isVictorious()) {
                return player.toString();
            }
        }
        return "No winner exists";
    }
    //determines if the game is over or not
    public boolean isGameOver() {
        //check to see if any players won
        for(CardPlayer player : players) {
            if(((CrazyEightPlayer)player).isVictorious()) {
                return true;
            }
        }
        //if no one made any moves during a turn, and the draw pile is empty,
        if(movesMade == 0 && deck.isDeckEmpty()) {
            return true;
        }
        //by default, return false
        return false;
    }
}
