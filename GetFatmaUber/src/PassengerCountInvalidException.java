
// Exception class for indicating an invalid passenger count.
public class PassengerCountInvalidException extends IllegalArgumentException {
    public PassengerCountInvalidException(String message) {
        super(message);
    }
}
