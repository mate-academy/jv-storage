package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>();
        Box box = new Box();
        storage.put(22, box);
        Box value = storage.get(22); // returns the Box
        int size = storage.size(); // returns storage size

        System.out.println(value == box); // true
        System.out.println(size); // 1

        Box newBox = new Box();
        storage.put(22, newBox);
        value = storage.get(22);

        System.out.println(value == newBox); // true
        System.out.println(storage.size()); // 1

        for (int i = 0; i < 10; i++) {
            storage.put(i, new Box());
        }
        System.out.println(storage.size()); // 10

        storage.put(11, new Box());
        System.out.println(storage.size()); // 10
    }
}
