public abstract class CardGame {
    protected CardPlayer [] players;
    
    public CardGame(CardPlayer [] players) {
        this.players = players;
    }
    
    public abstract void play();
    
    public abstract boolean isGameOver();
    
    public abstract String getWinner();
}
