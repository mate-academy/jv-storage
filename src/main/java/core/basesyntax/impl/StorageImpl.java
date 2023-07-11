package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int TOTAL_ROWS_NUMBER = 10;
    private static final int TOTAL_COLUMNS_NUMBER = 2;
    private static final int FIRST_COLUMNS_INDEX = 0;
    private static final int SECOND_COLUMNS_INDEX = 1;

    private final Object[][] storageArray;
    private int size;

    public StorageImpl() {
        storageArray = new Object[TOTAL_ROWS_NUMBER][TOTAL_COLUMNS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            storageArray[index][SECOND_COLUMNS_INDEX] = value;
        } else {
            if (size < TOTAL_ROWS_NUMBER) {
                storageArray[size][FIRST_COLUMNS_INDEX] = key;
                storageArray[size][SECOND_COLUMNS_INDEX] = value;
                size++;
            } else {
                throw new RuntimeException("Storage is full");
            }
        }
    }

    @Override
    public V get(K key) {
        int rowIndex = getIndex(key);
        return rowIndex != -1 ? (V) storageArray[rowIndex][SECOND_COLUMNS_INDEX] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            if (storageArray[rowIndex][FIRST_COLUMNS_INDEX] == key
                    || storageArray[rowIndex][FIRST_COLUMNS_INDEX] != null
                    && storageArray[rowIndex][FIRST_COLUMNS_INDEX].equals(key)) {
                return rowIndex;
            }
        }
        return -1;
    }
}
