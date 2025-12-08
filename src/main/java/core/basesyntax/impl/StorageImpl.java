package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[NUMBER];
        values = (V[]) new Object[NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
