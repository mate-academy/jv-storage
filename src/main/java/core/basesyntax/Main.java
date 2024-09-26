package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storageImpl = new StorageImpl<>();
        System.out.println(storageImpl);
        storageImpl.put(1, "Hello-1");
        storageImpl.put(2, "Hello-2");
        storageImpl.put(null, "Hello-3");
        storageImpl.put(4, null);
        System.out.println(storageImpl);
        System.out.println(storageImpl.get(1));
        System.out.println(storageImpl.get(3));
    }
}
