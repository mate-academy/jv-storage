package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl storage = new StorageImpl();
        Cat firstCat = new Cat("Bob", "red");
        storage.put(1, firstCat);
        Cat secondCat = new Cat("Bob1", "green");
        storage.put(2, secondCat);

        System.out.println(storage.size());
    }
}
