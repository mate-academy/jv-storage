package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_CAPACITY = 10;
    private final K[] keys = (K[]) new Object[ARRAY_CAPACITY];
    private final V[] values = (V[]) new Object[ARRAY_CAPACITY];

    @Override
    public void put(K key, V value) {
        int existingKeyIndex = findKey(key);
        int size = size();
        if (existingKeyIndex != -1) {
            this.values[existingKeyIndex] = value;
        } else if (size < ARRAY_CAPACITY) {
            this.keys[size] = key;
            this.values[size] = value;
        } else {
            throw new RuntimeException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        return findKey(key) != -1 ? values[findKey(key)] : null;
    }

    @Override
    public int size() {
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            if (values[i] == null) {
                return i;
            }
        }
        return ARRAY_CAPACITY;
    }

    private int findKey(K key) {
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            if (key == null) {
                if (keys[i] == null && values[i] != null) {
                    return i;
                }
            } else if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
