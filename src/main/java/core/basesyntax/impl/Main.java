package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Integer[] keys = new Integer[10];
        String[] values = new String[10];
        Storage<Integer, String> storage = new StorageImpl<>(keys, values);
        String elementOne = "One";
        String elementTwo = "Two";
        String elementThree = "Three";
        String elementFour = "Four";

        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(null, elementThree);
        storage.put(3, elementFour);

        System.out.println(storage.get(null));
        System.out.println(storage.size());
    }
}
