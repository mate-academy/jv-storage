package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Box<K, V>[] storage;

    public StorageImpl() {
        storage = new Box[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = new Box<>(key, value);
                return;
            }
            if (compareKeys(storage[i].getKey(), key)) {
                storage[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return null;
            }
            if (compareKeys(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Box<K, V> boxInStorage : storage) {
            if (boxInStorage != null) {
                count++;
            }
        }
        return count;
    }

    private boolean compareKeys(K firstKey, K secondKey) {
        return (firstKey == secondKey)
                || (secondKey != null && firstKey != null && secondKey.equals(firstKey));
    }
}
