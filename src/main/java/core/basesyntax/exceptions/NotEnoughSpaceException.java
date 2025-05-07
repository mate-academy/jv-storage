package core.basesyntax.exceptions;

public class NotEnoughSpaceException extends RuntimeException {
    public NotEnoughSpaceException(String errorMessage) {
        super(errorMessage);
    }
}
