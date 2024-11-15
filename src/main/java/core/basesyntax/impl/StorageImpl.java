package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_CAPACITY];
        values = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = indexKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAXIMUM_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
