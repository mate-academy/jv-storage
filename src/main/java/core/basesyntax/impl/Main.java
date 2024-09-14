package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box();
        storage.put(22, box);
        Box value = storage.get(22); // returns the Box
        int size = storage.size(); // returns storage size
        System.out.println(value);
        System.out.println(size);

        Storage<Integer, String> storage2 = new StorageImpl<>();
        storage2.put(23, "Hello");
        storage2.put(1, "Hello3");
        String value2 = storage2.get(23);
        int size2 = storage2.size();
        System.out.println(value2);
        System.out.println(size2);
    }
}
