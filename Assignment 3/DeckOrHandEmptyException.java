
/**
 * This exception is thrown when a card is "drawn" from and empty hand or deck.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class DeckOrHandEmptyException extends CardException {
    public DeckOrHandEmptyException(String message) {
        super(message);
    }
}
