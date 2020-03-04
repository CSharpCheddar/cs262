/*
 * Class that models a playing card
 */
public class Card implements Comparable<Card>{
    private Suit suit;
    private int rank;
    
    public Card(Suit suit, int rank) {
      this.rank = rank;
      this.suit = suit;     
    }
   
    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        String rankName = "";
        switch(rank) {
            case 1: rankName = "ACE"; break;
            case 2: rankName = "TWO"; break;            
            case 3: rankName = "THREE"; break;            
            case 4: rankName = "FOUR"; break;            
            case 5: rankName = "FIVE"; break;            
            case 6: rankName = "SIX"; break;           
            case 7: rankName = "SEVEN"; break;            
            case 8: rankName = "EIGHT"; break;   
            case 9: rankName = "NINE"; break;            
            case 10: rankName = "TEN"; break;            
            case 11: rankName = "JACK"; break;            
            case 12: rankName = "QUEEN"; break;      
            case 13: rankName = "KING"; break;               
            default: rankName = "INVALID"; 
        }
        String output = rankName + " of " + suit;
        return output ;
    }

    public int compareTo(Card c) {
        //get the numeric values of the enumerated types
        int thisSuit = suit.ordinal();
        int otherSuit = c.getSuit().ordinal();
        if (thisSuit < otherSuit)
            return -1;
        else if (thisSuit > otherSuit)
            return 1;
        else if (rank < c.getRank())
            return -1;
        else if (rank > c.getRank())
            return 1;
        else
            return 0;
    }

    //New method.
    public boolean equals(Object o) {
        if (o instanceof Card){
            Card c = (Card) o;
            if (this.compareTo(c) == 0)
                return true;
            else    
                return false;
        }
        return false;
    }    
}
