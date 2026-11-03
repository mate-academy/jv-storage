package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return i;
            }
            if (keys[i] != null) {
                if (keys[i].equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
        } else if (keyIndex == -1) {
            if (size < MAX_CAPACITY) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
