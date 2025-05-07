package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int INVALID_VALUE = -1;
    private Object[] key;
    private Object[] value;
    private int storageSize;

    public StorageImpl() {
        this.key = new Object[MAX_STORAGE_SIZE];
        this.value = new Object[MAX_STORAGE_SIZE];
        storageSize = 0;
    }

    @Override
    public void put(K key, V value) {
        if (findIndex(key) >= 0 && this.value[findIndex(key)] != null) {
            this.value[findIndex(key)] = value;
            return;
        }
        this.value[storageSize] = value;
        this.key[storageSize] = key;
        storageSize++;
    }

    @Override
    public V get(K key) {
        if (findIndex(key) >= 0) {
            return (V) value[findIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int findIndex(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if ((this.key[i] == null && key == null) || (key != null && key.equals(this.key[i]))) {
                return i;
            }
        }
        return INVALID_VALUE;
    }
}
