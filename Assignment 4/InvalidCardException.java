
/**
 * This exception is thrown when the user attempts to create or specify a Card that cannot exist.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class InvalidCardException extends CardException {
    public InvalidCardException(String message) {
        super(message);
    }
}
