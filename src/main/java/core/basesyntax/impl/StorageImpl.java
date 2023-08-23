package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private KeyValuePair<K, V>[] storage;
    private int currentSize;

    public StorageImpl() {
        storage = new KeyValuePair[MAX_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keyEquals(storage[i].getKey(), key)) {
                storage[i].setValue(value);
                return;
            }
        }

        if (currentSize < MAX_SIZE) {
            storage[currentSize] = new KeyValuePair<>(key, value);
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keyEquals(storage[i].getKey(), key)) {
                return storage[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private boolean keyEquals(K key1, K key2) {
        if (key1 == null && key2 == null) {
            return true;
        }
        return key1 != null && key1.equals(key2);
    }
}
