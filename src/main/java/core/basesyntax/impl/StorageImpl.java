package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_UNITS = 10;
    private static final int MAX_CELL_UNITS = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Object[][] storage = new Object[MAX_STORAGE_UNITS][MAX_CELL_UNITS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != -1) {
            storage[index][VALUE_INDEX] = value;
        } else {
            size++;
            storage[size][KEY_INDEX] = key;
            storage[size][VALUE_INDEX] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index != -1) {
            return (V) storage[index][VALUE_INDEX];
        } else {
            return null;
        }
    }

    private int getIndexByKey(K key) {
        for (int i = 1; i <= size; i++) {
            boolean result = key == null ? storage[i][KEY_INDEX] == null
                    : key.equals(storage[i][KEY_INDEX]);
            if (result) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
