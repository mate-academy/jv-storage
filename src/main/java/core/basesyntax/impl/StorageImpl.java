package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_INDEX = 10;
    private int storageSize;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        this.storageSize = 0;
        this.keys = new Object[MAX_INDEX];
        this.values = new Object[MAX_INDEX];
    }

    @Override
    public void put(K key, V value) {
        if (storageSize > 0) {
            int i = returnNumber(key);
            if (i != -1) {
                values[i] = value;
                return;
            }
        }
        keys[storageSize] = key;
        values[storageSize] = value;
        storageSize += 1;
    }

    @Override
    public V get(K key) {
        int i = returnNumber(key);
        if (i != -1) {
            return (V) values[i];
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int returnNumber(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return -1;

    }
}
