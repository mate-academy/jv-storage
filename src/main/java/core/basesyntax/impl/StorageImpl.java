package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;
    private int index;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_LENGTH];
        this.values = (V[]) new Object[MAX_LENGTH];
    }

    private int findKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        index = findKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (size < MAX_LENGTH) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        index = findKey(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
