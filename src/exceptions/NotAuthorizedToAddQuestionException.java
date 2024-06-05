package exceptions;

public class NotAuthorizedToAddQuestionException extends Exception {
    public NotAuthorizedToAddQuestionException(String message) {
        super(message);
    }
}
