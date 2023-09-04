package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

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
            if (indexKey == size) {
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int indexKey = indexOf(key);
        if (indexKey == -1) {
            return null;
        }
        return (V) values[indexOf(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            boolean keysAreEqual = key == null ? key == keys[i]
                    : key.equals(keys[i]);
            if (keysAreEqual) {
                return i;
            }
        }
        return -1;
    }
}

