package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> stor = new StorageImpl();
        stor.put(1, "first");
        stor.put(2, "second");
        stor.put(3, "third");
        stor.put(2, "second2");
    }
}
