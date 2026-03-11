package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();

        storage.put(1, "one");
        storage.put(2, "two");
        storage.put(1, "ONE");

        System.out.println(storage.get(1));
        System.out.println(storage.get(2));
        System.out.println(storage.size());
    }
}
