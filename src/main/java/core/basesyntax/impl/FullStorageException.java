package core.basesyntax.impl;

public class FullStorageException extends RuntimeException {

    public FullStorageException() {
        super("Storage is full");
    }
}
