
/**
 * Creates a game of Crazy Eights against a human player and a simple AI.
 *
 * @author Martin Mueller
 * @version 04/29/2018
 */
public class Driver {
    public static void main() {
        int handSize = 5;
        CardPlayer[] players = {
            new CrazyEightHumanPlayer("Human", handSize),
            new CrazyEightComputerPlayer("Computer", handSize)
        };
        CrazyEightGame game = new CrazyEightGame(players, handSize);
        System.out.println("Starting game of Crazy Eights...");
        game.play();
    }
}
