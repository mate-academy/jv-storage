package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class MainStorage {
    public static void main(String[] args) {

        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box();
        storage.put(22, box);
        System.out.println(storage.size());
        System.out.println(storage.get(22));

        Box secondBox = new Box();
        storage.put(22,secondBox);
        System.out.println(storage.get(22));

        storage.put(56,new Box());
        System.out.println(storage.size());
        System.out.println(storage.get(56));
        System.out.println(storage.size());
    }
}
