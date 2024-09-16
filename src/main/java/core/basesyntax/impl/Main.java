package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box("beautiful1", 4, 8);
        Box box2 = new Box("beautiful2", 6, 9);
        Box box3 = new Box("beautiful3", 5, 7);
        storage.put(22, box);
        storage.put(23, box2);
        storage.put(24, box3);
        Box value = storage.get(22); // returns the Box
        Box value2 = storage.get(23);
        Box value3 = storage.get(24);
        int size = storage.size(); // returns storage size
        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(size);

//        Storage<Integer, String> storage2 = new StorageImpl<>();
//        storage2.put(23, "Hello");
//        storage2.put(1, "Hello3");
//        String value3 = storage2.get(23);
//        int size2 = storage2.size();
//        System.out.println(value3);
//        System.out.println(size2);
    }
}
