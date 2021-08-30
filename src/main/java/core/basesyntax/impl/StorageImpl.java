package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[MAX_ARRAY_SIZE];
    private V[] values = (V[]) new Object[MAX_ARRAY_SIZE];
    private int sizeOfStorage = 0;

    @Override
    public void put(K key, V value) {
        if (sizeOfStorage >= MAX_ARRAY_SIZE) {
            throw new RuntimeException("Sorry, but the storage is full.");
        }
        for (int i = 0; i < sizeOfStorage; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[sizeOfStorage] = key;
        values[sizeOfStorage] = value;
        sizeOfStorage++;
        return;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}
