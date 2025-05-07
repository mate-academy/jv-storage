package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl();
        storage.put(1, "one");
        storage.put(-1, "one");
        storage.put(2, "two");
        storage.put(2, "TWO");
        storage.put(3, "three");
        storage.put(4, null);

        System.out.println(storage.get(6));
        System.out.println(storage.size());
    }
}
