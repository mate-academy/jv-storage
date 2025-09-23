package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<String, Integer> storage = new StorageImpl<>();

        storage.put("test", 1);
        storage.put("test", 2);
//        storage.put("test", 3);
        System.out.println(storage.get("tes2t"));
    }
}
