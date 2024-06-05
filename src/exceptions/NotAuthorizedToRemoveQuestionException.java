package exceptions;

public class NotAuthorizedToRemoveQuestionException extends Exception {
    public NotAuthorizedToRemoveQuestionException(String message) {
        super(message);
    }
}
