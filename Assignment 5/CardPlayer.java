public abstract class CardPlayer {
    protected String name;
    public CardPlayer(String name) {
        this.name = name;
    }
    
    public abstract Card takeTurn();

    public abstract void dealCard(Card card);
    
    public String toString() {
        return name;
    }
}
