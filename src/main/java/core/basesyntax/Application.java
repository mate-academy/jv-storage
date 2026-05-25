package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Application {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(1, "Value1");
        storage.put(2, "Value2");
        storage.put(3, "Value3");

        System.out.println("Get value by key 2: " + storage.get(2));
        System.out.println("Storage size: " + storage.size());

        storage.put(1, "NewValue1");
        System.out.println("Get updated value by key 1: " + storage.get(1));
    }
}
