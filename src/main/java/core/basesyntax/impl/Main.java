package core.basesyntax.impl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        storage.put(22, "Element 1");
        storage.put(22, "Element 1 replace");
        storage.put(3, "Element 3");
        storage.put(4, "Element 4");
        storage.put(4, "Element 4");
        storage.put(4, "Element 6");
        storage.put(4, "Element 4");
        storage.put(8, "Element 4");
        storage.put(4, "Element 7");
        storage.put(9, "Element 2");
        System.out.println(storage.get(22));
        System.out.println(storage.size());
    }
}

