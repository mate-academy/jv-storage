package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] storage;
    private int currentSize = 0;

    public StorageImpl() {
        storage = new Object[20];

    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (key == storage[i] || (key != null && key.equals(storage[i]))) {
                storage[i + 10] = value;
                return;
            }
        }
        storage[currentSize] = key;
        storage[currentSize + 10] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (key != null && key.equals(storage[i]) || key == storage[i]) {
                return (V) storage[i + 10];
            }
        }
        return null;
    }
}
