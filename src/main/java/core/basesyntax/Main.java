package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        storage.put(1, "String 1");
        storage.put(2, "String 2");
        storage.put(1, "String 3");
        System.out.println(storage);
        System.out.println(storage.get(1));
        System.out.println(storage.get(2));
    }
}
