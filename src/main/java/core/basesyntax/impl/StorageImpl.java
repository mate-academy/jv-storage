package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_UNITS = 10;
    private static final int MAX_CELL_UNITS = 2;
    private final Object[][] storage = new Object[MAX_STORAGE_UNITS][MAX_CELL_UNITS];
    private int filledCells = 0;

    @Override
    public void put(K key, V value) {
        int index = getValueIndexByKey(key);
        if (index != -1) {
            storage[index][1] = value;
        } else {
            filledCells++;
            storage[filledCells][0] = key;
            storage[filledCells][1] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getValueIndexByKey(key);
        if (index != -1) {
            return (V) storage[index][1];
        } else {
            return null;
        }
    }

    private int getValueIndexByKey(K key) {
        for (int i = 1; i <= filledCells; i++) {
            boolean result = key == null ? storage[i][0] == null : key.equals(storage[i][0]);
            if (result) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return filledCells;
    }
}
