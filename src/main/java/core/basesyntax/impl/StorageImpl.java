package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;

    private K[] keys = (K[]) new Object[MAX_STORAGE_LENGTH];

    private V[] values = (V[]) new Object[MAX_STORAGE_LENGTH];

    private int storageIndex = 0;

    @Override
    public void put(K key, V value) {
        if (isNoMoreSpace()) {
            return;
        }

        if (doesItemExist(key, value)) {
            return;
        }

        this.keys[storageIndex] = key;
        this.values[storageIndex] = value;

        storageIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageIndex; i++) {
            if (key != null ? key.equals(keys[i]) : keys[i] == null) {
                return values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return storageIndex;
    }

    private boolean isNoMoreSpace() {
        return storageIndex - 1 >= MAX_STORAGE_LENGTH;
    }

    private boolean doesItemExist(K key, V value) {
        for (int i = 0; i < storageIndex; i++) {
            if (key != null ? key.equals(keys[i]) : keys[i] == null) {
                this.values[i] = value;

                return true;
            }
        }

        return false;
    }
}
