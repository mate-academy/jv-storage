package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(0, "Shrek");
        storage.put(1, "Billy Herrington");
        storage.put(2, "Obivan");
        storage.put(0, "Ivanko");
        System.out.println(storage.get(3));
        System.out.println(storage.get(0));
    }
}
