package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int counter;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index < 0) {
            keys[counter] = key;
            values[counter] = value;
            counter++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index < 0) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return counter;
    }

    private int findIndex(K key) {
        for (int i = 0; i < counter; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
