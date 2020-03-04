
/**
 * Tests out a game of Higher Card played by random computer players.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class OldDriver {
    public static void oldMain() {
        int rounds = 3;
        HigherCardPlayer[] players = {
            new HigherCardComputerPlayer("A", rounds),
            new HigherCardComputerPlayer("B", rounds),
            new HigherCardComputerPlayer("C", rounds),
            new HigherCardComputerPlayer("D", rounds)
        };
        HigherCardGame game = new HigherCardGame(players, rounds);
        game.play();
    }
}
