package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int arraySize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if ((key != null && key.equals(keys[i]) || (key == keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[arraySize] = key;
        values[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if ((key != null && key.equals(keys[i]) || (key == keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}

