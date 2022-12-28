package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys = (K[]) new Object[MAX_CAPACITY];
    private V[] values = (V[]) new Object[MAX_CAPACITY];
    private int storageCounter = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0;i < storageCounter;i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[storageCounter] = key;
        values[storageCounter] = value;
        storageCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0;i < storageCounter;i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageCounter;
    }
}
