package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private int count;
    private K[] keys = (K[]) new Object[MAX_STORAGE_SIZE];
    private V[] values = (V[]) new Object[MAX_STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == (K) keys[i] || (key != null && key.equals((keys[i])))) {
                values[i] = value;
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == (K) keys[i] || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
