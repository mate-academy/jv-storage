package core.basesyntax;

import core.basesyntax.impl.StorageImpl;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StorageImpl storage = new StorageImpl();
        Cat firstCat = new Cat("Bob", "red");
        storage.put(1, firstCat);
        Cat secondCat = new Cat("Bob1", "green");
        storage.put(2, secondCat);
        Cat cat1 = new Cat("Bob1", "green");
        storage.put(3, cat1);
        Cat cat2 = new Cat("Bob1", "green");
        storage.put(4, cat2);
        Cat cat3 = new Cat("Bob1", "green");
        storage.put(5, cat3);
        Cat cat4 = new Cat("Bob1", "green");
        storage.put(6, cat4);
        Cat cat5 = new Cat("Bob1", "green");
        storage.put(7, cat5);
        Cat cat6 = new Cat("Bob1", "green");
        storage.put(8, cat6);
        Cat cat7 = new Cat("Bob1", "green");
        storage.put(9, cat7);
        Cat cat8 = new Cat("Bob1", "green");
        storage.put(10, cat8);
        Cat cat9 = new Cat("Bob222222", "green");
        storage.put(10, cat9);

        System.out.println(storage.size());
        System.out.println(Arrays.toString(storage.getStorage()));
        System.out.println(storage.get(10));
    }
}
