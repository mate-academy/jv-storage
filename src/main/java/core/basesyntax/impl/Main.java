package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Box b1 = Box.of(1, "guf1");
        Box b2 = Box.of(2, "guf2");
        Box b3 = Box.of(3, "guf3");
        Box b4 = Box.of(4, "guf4");

        Storage<Integer, Box> storage = new StorageImpl<>();
        storage.put(null, b1);
        storage.put(22, b2);
        storage.put(33, b3);
        storage.put(22, b4);

        Box value1 = storage.get(null); // returns the Box
        Box value2 = storage.get(22); // returns the Box
        Box value3 = storage.get(33); // returns the Box

        int size = storage.size();
        System.out.println(size);
        System.out.println(value1 + " - value ");
        System.out.println(value2 + " - value ");
        System.out.println(value3 + " - value ");

    }
}
