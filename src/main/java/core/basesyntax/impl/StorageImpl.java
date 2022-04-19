package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_CAPACITY = 10;
    private final K[] keys = (K[]) new Object[ARRAY_CAPACITY];
    private final V[] values = (V[]) new Object[ARRAY_CAPACITY];
    private int size;

    @Override
    public void put(K key, V value) {
        if (size == ARRAY_CAPACITY) {
            throw new RuntimeException("Storage is full!");
        }
        int existingKeyIndex = findKeyIndex(key);
        if (existingKeyIndex != -1) {
            this.values[existingKeyIndex] = value;
            return;
        }
        this.keys[size] = key;
        this.values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        return keyIndex != -1 ? values[keyIndex] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
