public class HigherCardComputerPlayer extends HigherCardPlayer {
    private int rounds; //do not need this, for my implementation; 
    private int roundsWon;
    
    public HigherCardComputerPlayer(String name, int rounds) {
        super(name, rounds);
        this.rounds = rounds;
        hand = new Hand(rounds);
        roundsWon = 0;
    }

    public Card takeTurn(){
        return hand.drawNext();
    }

    public void dealCard(Card card){
        hand.addCard(card);
    }
    
    public void updateRoundsWon(){
        roundsWon++;
    }
    
    public int getRoundsWon(){
        return roundsWon;
    }   
}
