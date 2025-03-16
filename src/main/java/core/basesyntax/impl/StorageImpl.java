package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[storageSize] = key;
        values[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                result = values[i];
            }
        }
        return result;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
