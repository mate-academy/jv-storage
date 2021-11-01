package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String val1 = "value1";

        storage.put(null, val1);

        String value = storage.get(null);
        int size = storage.size();

        System.out.println(value + " value");
        System.out.println(size + " size");
    }
}
