package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int lstElemIndex = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lstElemIndex; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }

        keys[lstElemIndex] = key;
        values[lstElemIndex] = value;
        lstElemIndex++;
    }

    @Override
    public V get(K key) {
        int resultKey = -1;
        for (int i = 0; i < lstElemIndex; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                resultKey = i;
            }
        }

        if (resultKey != -1) {
            return values[resultKey];
        }
        return null;
    }

    @Override
    public int size() {
        return lstElemIndex;
    }
}
