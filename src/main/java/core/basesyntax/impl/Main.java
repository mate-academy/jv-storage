package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box<String>> storage = new StorageImpl<>();

        Box<String> box = new Box<>("something");
        storage.put(22, box);

        Box<String> value = storage.get(22);
        System.out.println(value);

        System.out.println("Size: " + storage.size());

        Box<String> newBox = new Box<>("new content");
        storage.put(22, newBox);
        System.out.println(storage.get(22));
        System.out.println("Size: " + storage.size());
    }
}

