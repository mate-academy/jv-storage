package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private int lastIndex;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        lastIndex = 0;
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (lastIndex >= MAX_SIZE) {
            throw new RuntimeException("Storage maximum size is reached");
        }
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[lastIndex] = key;
        values[lastIndex] = value;
        lastIndex++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return lastIndex;
    }

    private int getIndex(K key) {
        for (int i = 0; i < lastIndex; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
