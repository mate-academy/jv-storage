package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Storage capacity exceeded");
        }
        int keyIndex = index(key);

        if (keyIndex >= 0) {
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }

    }

    @Override
    public V get(K key) {
        int keyIndex = index(key);
        if (keyIndex >= 0) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int index(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                continue;
            }
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

}
