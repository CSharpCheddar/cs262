/*
 * Class that models a hand of cards held by a player
 */
import java.util.ArrayList;
public class Hand {
    private ArrayList<Card> cards;
    
    public Hand(int m){
        //Does not use the parameter
        cards = new ArrayList<>();
    }
 
    public Card drawNext(){
       if (cards.size() == 0)
            throw new DeckOrHandEmptyException();
       Card c = cards.get(cards.size()-1);     
       cards.remove(cards.size()-1);     
       return c;        
    }  

    public Card draw(String s) {
        //draws specific card from hand, in format "8s", "1c", "11h", "13d"
        if (s.length() < 2)
             throw new InvalidCardException();
        String val = s.substring(s.length()-1).toLowerCase();
        Suit suit = null;
        switch(val){
            case "c": suit = Suit.CLUBS; break;
            case "d": suit = Suit.DIAMONDS; break;
            case "h": suit = Suit.HEARTS; break;
            case "s": suit = Suit.SPADES; break;
        }
        if (suit == null)
            throw new InvalidCardException();
            
        int rank = 0;
        try{ 
               rank = Integer.parseInt(s.substring(0,s.length()-1)); 
        }
        catch(Exception e){ throw new InvalidCardException(); }
        if (rank < 1 || rank > 13)
            throw new InvalidCardException();
        
        Card c = new Card(suit,rank);  

        if (!cards.remove(c))
             throw new InvalidCardException();
             
        //Finally, after all validations, we can return the card:
        return c;
    }    
    
    public void addCard(Card c){ //adds it anywhere in hand, currently at the end
        cards.add(c);
    }
    
    //New method: accessor for cards in hand; 
    //for use by user interfaces that display the cards
    public ArrayList<Card> getCards(){
        return cards;
    }
}
