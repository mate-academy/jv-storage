package core.basesyntax.impl;

public class StorageIsFullException extends IllegalStateException {
    public StorageIsFullException(String s) {
        super(s);
    }
}
