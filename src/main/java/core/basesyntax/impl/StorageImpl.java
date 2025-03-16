package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("ALL")

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_STORAGE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH_STORAGE];
        values = (V[]) new Object[MAX_LENGTH_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size < MAX_LENGTH_STORAGE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
