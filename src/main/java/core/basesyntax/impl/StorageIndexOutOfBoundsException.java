package core.basesyntax.impl;

public class StorageIndexOutOfBoundsException extends RuntimeException {
    public StorageIndexOutOfBoundsException(int storageLength) {
        super("You can't put more than " + storageLength + " elements in StorageImpl");
    }
}
