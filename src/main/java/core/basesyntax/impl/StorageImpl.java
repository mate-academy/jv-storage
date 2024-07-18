package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < MAX_ARRAY_LENGTH) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
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
            if (keys[i] == null && key == null) {
                return i;
            } else if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
