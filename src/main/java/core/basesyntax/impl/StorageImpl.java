package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_RAW = 10;
    private static final int NUMBER_OF_COLUMN = 2;
    private static final int INDEX_OF_KEY = 0;
    private static final int INDEX_OF_VALUE = 1;
    private final Object[][] storage = new Object[NUMBER_OF_RAW][NUMBER_OF_COLUMN];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            storage[size][INDEX_OF_KEY] = key;
            storage[size][INDEX_OF_VALUE] = value;
            size++;
        } else {
            storage[getIndex(key)][INDEX_OF_VALUE] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        }
        return (V) storage[getIndex(key)][INDEX_OF_VALUE];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < NUMBER_OF_RAW; i++) {
            if (key != null && key.equals(storage[i][INDEX_OF_KEY])
                    || key == null && storage[i][INDEX_OF_KEY] == null
                    && storage[i][INDEX_OF_VALUE] != null) {
                return i;
            }
        }
        return -1;
    }
}
