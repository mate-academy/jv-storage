package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] storage = new Object[MAX_STORAGE_SIZE][2];
    private int actualStorageSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (storage[i][KEY_INDEX] == null && storage[i][VALUE_INDEX] == null) {
                actualStorageSize++;
                storage[i][KEY_INDEX] = key;
                storage[i][VALUE_INDEX] = value;
                break;
            } else if (key == null && storage[i][KEY_INDEX] == null
                    || key != null && key.equals(storage[i][KEY_INDEX])) {
                storage[i][VALUE_INDEX] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_STORAGE_SIZE; i++) {
            if (key == null && storage[i][KEY_INDEX] == null
                    || key != null && key.equals(storage[i][KEY_INDEX])) {
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
