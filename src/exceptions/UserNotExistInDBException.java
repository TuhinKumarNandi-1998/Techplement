package exceptions;

public class UserNotExistInDBException extends Exception {
    public UserNotExistInDBException(String message) {
        super(message);
    }
}
