package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]
                    || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index >= 0) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index >= 0) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
