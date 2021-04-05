package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final Box<K, V>[] storage;

    public StorageImpl() {
        storage = new Box[MAX_STORAGE_SIZE];
    }

    private boolean areBothKeysNullOrEqual(K firstKey, K secondKey) {
        return (firstKey == null && secondKey == null)
                || (secondKey != null && firstKey != null && secondKey.equals(firstKey));
    }

    @Override
    public void put(K key, V value) {
        Box<K, V> box = new Box<>(key, value);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = box;
                return;
            }
            if (areBothKeysNullOrEqual(storage[i].getKey(), key)) {
                storage[i] = box;
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
            if (areBothKeysNullOrEqual(storage[i].getKey(), key)) {
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
}
