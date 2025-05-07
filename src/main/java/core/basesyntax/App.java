package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class App {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        for (int i = 0; i < 15; i++) {
            storage.put(i, "Map element number " + i);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(storage.get(i));
        }
    }
}
