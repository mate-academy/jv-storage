package core.basesyntax.impl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<String, Integer> storageImpl = new StorageImpl<>();

        for (int i = 0; i < 10; i++) {
            storageImpl.put("key" + i, i);
        }
    }
}
