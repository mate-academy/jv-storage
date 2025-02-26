package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box();
        storage.put(22, box);
        Box value = storage.get(22);
        int size = storage.size();
        System.out.println("Size:" + size);
        System.out.println("Value:" + value);
    }
}
