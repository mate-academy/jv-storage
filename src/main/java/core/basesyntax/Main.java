package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        String box = "box3";
        storage.put(44, box);
        storage.put(22, box);
        storage.put(33, box);
        storage.size();

        System.out.println(storage.get(33));
        System.out.println(storage.size());
    }
}
