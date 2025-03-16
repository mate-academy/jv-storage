package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "One";
        String elementTwo = "Two";
        String elementThree = "Three";
        String elementFour = "Four";

        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(null, elementThree);
        storage.put(3, elementFour);
        System.out.println(storage.get(null));

    }
}
