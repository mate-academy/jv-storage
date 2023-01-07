package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer,String> storage = new StorageImpl<>();
        storage.put(1,"First");
        storage.put(null,"0000");
        storage.put(2,"Second");
        storage.put(3, "Third");
        storage.put(1, "First_two");
        storage.put(null, "Null Two");
        System.out.println(storage.size());
    }
}
