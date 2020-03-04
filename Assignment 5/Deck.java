/*
 * Class that models a deck of cards
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final int DECK_SIZE = 52;
    private ArrayList<Card> cards;
    
    //Creates a full deck
    public Deck() {
      cards = new ArrayList<>(DECK_SIZE);
      Suit [] suits = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
      int j = 0;
      for (Suit s: suits){
          for (int i = 1; i <= 13; i++){
              cards.add(new Card(s,i));
          }
      }
    } 
    
    //New method: allows a Deck to be created from a given set of cards
    public Deck(ArrayList<Card> cards) {
      this.cards = cards;
    } 
    
    public String toString() {
        String output = "[\n";
        for (int i = cards.size()-1; i >= 0; i--)
            output += "\t" +i+": "+ cards.get(i) + ",\n";
        return output + "]";
    }

    public boolean isDeckEmpty(){
        if (cards.size() == 0)
            return true;
        return false;
    }
    
    public Card deal() {
        if (cards.size() == 0)
            throw new DeckOrHandEmptyException();
        Card c = cards.get(cards.size()-1);     
        cards.remove(cards.size()-1);     
        return c;        
    }
    
    public void shuffle(){
        //Standard approach to shuffle cards
        //Walk through each card slot, and pick another random slot to exchange it with.
        Random random = new Random();
 
        for (int i = 0; i< cards.size(); i++){
            int swapSlot = random.nextInt(DECK_SIZE); //0-51
            Collections.swap(cards, i, swapSlot);
            //Hopefully this is implemented efficiently by the Java API!
        }
    }
}
