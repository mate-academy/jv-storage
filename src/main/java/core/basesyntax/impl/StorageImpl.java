package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final Object [] keys;
    private final Object [] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        } else {
            this.keys[index] = key;
            this.values[index] = value;
        }
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key)
                    || (keys[i] != null && key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
