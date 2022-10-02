package core.basesyntax.impl;

public class StorageOverflowError extends RuntimeException {
    public StorageOverflowError(String message) {
        super(message);
    }
}
