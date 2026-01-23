package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();

        storage.put(0, "Cześć");
        String value = storage.get(0);

        System.out.println("Wartość " + value);
        System.out.println("Rozmiar " + storage.size());

    }
}
