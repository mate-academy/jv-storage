package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final String TRIGGER_FOR_NULL = "null";
    private final K[] keys = (K[]) new Object[MAX_STORAGE_SIZE];
    private final V[] values = (V[]) new Object[MAX_STORAGE_SIZE];
    private int index;
    private int size;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            keys[index] = (K) TRIGGER_FOR_NULL;
        } else {
            keys[index] = key;
        }
        values[index] = value;
        index++;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            key = (K) TRIGGER_FOR_NULL;
        }
        for (int i = MAX_STORAGE_SIZE; i > 0; i--) {
            if (key.equals(keys[i - 1])) {
                size--;
                return values[i - 1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
