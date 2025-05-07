package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private V[] values;
    private K[] keys;
    private int size;

    public StorageImpl() {
        values = (V[]) new Object[MAX_STORAGE];
        keys = (K[]) new Object[MAX_STORAGE];

    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);

        if (index != -1) {
            values[index] = value;
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null
                    || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
