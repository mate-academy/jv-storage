package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int arrayLength;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_STORAGE_SIZE];
        this.values = (V[]) new Object[MAX_STORAGE_SIZE];
    }
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayLength; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[arrayLength] = key;
        values[arrayLength] = value;
        arrayLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayLength; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayLength;
    }
}
