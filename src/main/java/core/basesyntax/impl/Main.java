package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main extends StorageImpl {
    public static void main(String[] args) {

        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(1991, "Independence of Ukraine");

        String value = storage.get(1991);
        int size = storage.size();

        System.out.println("Value: " + value);
        System.out.println("Size: " + size);
    }
}
