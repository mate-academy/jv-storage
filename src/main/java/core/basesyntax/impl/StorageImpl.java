package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    Object keys[];
    Object values[];
    int putCount;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
        putCount = 0;
    }

    @Override
    public void put(K key, V value) {
        if (value != null && !Arrays.asList(keys).contains(key)) {
            keys[putCount] = key;
            values[putCount] = value;
            putCount++;
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)) {
                value = (V) values[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return putCount;
    }
}
