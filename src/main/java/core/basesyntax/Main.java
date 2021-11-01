package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String val1 = "value1";
        String val2 = "value2";

        storage.put(22, val1);
        storage.put(22, val2);

        String value = storage.get(22);
        int size = storage.size();

        System.out.println(value + " value");
        System.out.println(size + " size");
    }
}
