package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ROWS_SIZE = 10;
    private static final int COLUMNS_SIZE = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] keysAndValues;
    private int size;

    public StorageImpl() {
        keysAndValues = new Object[MAX_ROWS_SIZE][COLUMNS_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            keysAndValues[index][VALUE_INDEX] = value;
        } else {
            keysAndValues[size][KEY_INDEX] = key;
            keysAndValues[size][VALUE_INDEX] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return (V) keysAndValues[index][VALUE_INDEX];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAndValues[i][KEY_INDEX] == key
                    || (keysAndValues[i][KEY_INDEX] != null
                    && keysAndValues[i][KEY_INDEX].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
