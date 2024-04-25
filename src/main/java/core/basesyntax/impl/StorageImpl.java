package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    private boolean isValid(K key, int index) {
        return key == null && keys[index] == null || key != null && key.equals(keys[index]);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isValid(key,i)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isValid(key,i)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
