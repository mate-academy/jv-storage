package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[])new Object[MAX_SIZE];
        this.values = (V[])new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            values[indexOf(key)] = value;
            return;
        }
        if (size != MAX_SIZE - 1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return indexOf(key) < 0 ? null : values[indexOf(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == null && keys[i] == null || (keys[i] != null
                    && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
