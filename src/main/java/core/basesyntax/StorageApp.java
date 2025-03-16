package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class StorageApp {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl();
        storage.put(1, "Denys");
        storage.put(null, "Anton");
        storage.put(3, "Makar");
        storage.put(4, "Alex");
        storage.put(5, "Tan");

        System.out.println(storage.get(3));
        System.out.println(storage.get(1));
        System.out.println(storage.size());
    }
}
