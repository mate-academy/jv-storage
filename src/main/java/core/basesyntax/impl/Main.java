package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(null, elementOne);
        storage.put(null, elementTwo);
        storage.get(null);
        System.out.println(storage.size());
    }
}
