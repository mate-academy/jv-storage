package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ROWS_SIZE = 10;
    private static final int COLUMNS_SIZE = 2;
    private Object[][] keysAndValues;
    private int size;

    public StorageImpl() {
        keysAndValues = new Object[MAX_ROWS_SIZE][COLUMNS_SIZE];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAndValues[i][0] == key || (keysAndValues[i][0] != null
                    && keysAndValues[i][0].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            keysAndValues[index][1] = value;
        } else {
            keysAndValues[size][0] = key;
            keysAndValues[size][1] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return (V) keysAndValues[index][1];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
