package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();

        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";

        storage.put(1, elementOne);
        System.out.println(storage.get(1));
        System.out.println(storage.size());

        storage.put(2, elementTwo);
        System.out.println(storage.get(2));
        System.out.println(storage.size());

        storage.put(3, elementTree);
        System.out.println(storage.get(3));
        System.out.println(storage.size());
    }
}
