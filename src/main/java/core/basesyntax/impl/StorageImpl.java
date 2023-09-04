package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int indexKey = indexOf(key);
        if (indexKey == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[indexKey] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexKey = indexOf(key);
        if (indexKey == -1) {
            return null;
        }
        return values[indexKey];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
