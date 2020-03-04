import java.util.ArrayList;
public abstract class HigherCardPlayer extends CardPlayer {
    protected Hand hand;
    protected int rounds;
    protected int roundsWon;
    
    public HigherCardPlayer(String name, int rounds) {
        super(name);
        this.rounds = rounds;
        hand = new Hand(rounds);
        roundsWon = 0;
    }

    //New method: accessor for cards in hand; 
    //for use by user interfaces that display the cards
    public ArrayList<Card> getCards(){
        return hand.getCards();
    }    
    
    public abstract void updateRoundsWon();
    
    public abstract int getRoundsWon();
}
