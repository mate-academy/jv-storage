package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> stringStorage = new StorageImpl<>();
        stringStorage.put(1, "One");
        stringStorage.put(2, "Two");
        stringStorage.put(3, "Three");

        System.out.println(stringStorage.get(1));
        System.out.println(stringStorage.get(2));
        System.out.println(stringStorage.get(3));

        System.out.println("Size of storage: " + stringStorage.size());
    }
}
