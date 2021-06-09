package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] storage;
    private int actualStorageSize;

    public StorageImpl() {
        storage = new Object[MAX_STORAGE_SIZE][2];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < actualStorageSize; i++) {
            if (storage[i][KEY_INDEX] == key || key != null && key.equals(storage[i][KEY_INDEX])) {
                storage[i][VALUE_INDEX] = value;
                return;
            }
        }
        storage[actualStorageSize][KEY_INDEX] = key;
        storage[actualStorageSize][VALUE_INDEX] = value;
        actualStorageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < actualStorageSize; i++) {
            if (key == storage[i][KEY_INDEX] || key != null && key.equals(storage[i][KEY_INDEX])) {
                return (V) storage[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return actualStorageSize;
    }
}
