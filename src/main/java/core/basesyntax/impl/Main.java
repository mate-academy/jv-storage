package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        String elementFour = "Element 4";
        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(3, elementTree);
        storage.put(4, elementFour);
        System.out.println(storage.get(1));
        System.out.println(storage.get(null));
        System.out.println(storage.get(3));
        System.out.println(storage.get(4));
    }

}
