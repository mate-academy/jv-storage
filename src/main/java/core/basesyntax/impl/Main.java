package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "One";
        String elementTwo = "Two";
        String elementThree = "Three";
        String elementFour = "Four";

        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(null, elementThree);
        storage.put(3, elementFour);
    }
}
