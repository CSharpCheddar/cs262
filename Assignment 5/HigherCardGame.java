/**
 * This plays a game of Higher Card as per the rules set out in Assignment 3.
 * 
 * @author Martin Mueller
 * @version 05/09/2018
 */

import java.util.ArrayList;

public class HigherCardGame extends CardGame{
    private Deck deck;
    private int rounds, turns;
    private String lastRoundWinner; //the name of last round's winner
    //these are copies of the players' hands
    private ArrayList<Card> computerCards;
    private ArrayList<Card> playerCards;
    
    public HigherCardGame(HigherCardPlayer [] players, int rounds) {
        super(players);
        this.rounds = rounds;
        this.turns = 0;
        
        deck = new Deck();
        deck.shuffle();
        
        //deal one card per player per round
        for (int i = 0; i<rounds; i++){
            for (int j=0; j<players.length; j++) {
                players[j].dealCard(deck.deal());
            }
        }
        //create copies of each hand
        computerCards = new ArrayList<>();
        for(Card card : players[0].getCards()) {
            Card newCard = new Card(card.getSuit(), card.getRank());
            computerCards.add(newCard);
        }
        playerCards = new ArrayList<>();
        for(Card card : players[1].getCards()) {
            Card newCard = new Card(card.getSuit(), card.getRank());
            playerCards.add(newCard);
        }
    }
    
    @Override
    public void play(){
        //find out which cards were just played
        Card[] cards = new Card[2];
        for(Card card : computerCards) {
            if(!(((HigherCardPlayer)players[0]).getCards().contains(card))) {
                cards[0] = card;
                computerCards.remove(card);
                break;
            }
        }
        for(Card card : playerCards) {
            if(!(((HigherCardPlayer)players[1]).getCards().contains(card))) {
                cards[1] = card;
                playerCards.remove(card);
                break;
            }
        }
        //update the score
        ((HigherCardPlayer)players[getRoundWinner(cards)]).updateRoundsWon();
        turns++;
    }

    private int getRoundWinner(Card[] playedThisTurn){
        //Find greatest card
        int greatest = 0;
        if(playedThisTurn[1].compareTo(playedThisTurn[0]) > 0) {
            greatest = 1;
        }
        //gives the name of the winner of this round
        lastRoundWinner = players[greatest].toString();
        return greatest;        
    }
    
    public  boolean isGameOver(){
        if (turns >= rounds)
            return true;

        return false;
    }
    //returns the name of the winner of the last round
    public String getRoundWinner() {
        return "Round Winner: "+lastRoundWinner;
    }
    
    public String getWinner(){
        if(isGameOver()) {
            //Find greatest card
            int greatest = 0;
            for (int i=1; i < players.length; i++) {
                int a = ((HigherCardPlayer)players[greatest]).getRoundsWon();
                int b = ((HigherCardPlayer)players[i]).getRoundsWon();
                if (b > a) {
                    greatest = i;
                }
            }
            //return the winner
            return "Winner: " + players[greatest];
        }
        //if there is no winner yet, return this
        return "Winner: -";
    }
}
