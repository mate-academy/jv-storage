package core.basesyntax.impl;

public class StorageIsFullException extends RuntimeException {
    public StorageIsFullException(String message) {
        super(message);
    }
}
