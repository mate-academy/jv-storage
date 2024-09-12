package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String box = "my box";
        storage.put(22, box);
        String value = storage.get(22); // returns the Box
        int size = storage.size(); // returns storage size
    }
}
