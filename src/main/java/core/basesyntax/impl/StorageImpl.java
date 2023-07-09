package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_ROWS_NUMBER = 1;
    private static final int TOTAL_COLUMNS_NUMBER = 2;
    private static final int FIRST_ROW_NUMBER = 0;
    private static final int FIRST_COLUMNS_INDEX = 0;
    private static final int SECOND_COLUMNS_INDEX = 1;
    private static final int START_ARRAY_COPY_POSITION = 0;

    private Object[][] storageArray;
    private boolean isContainNullKey;

    public StorageImpl() {
        this.storageArray = new Object[START_ROWS_NUMBER][TOTAL_COLUMNS_NUMBER];
        this.isContainNullKey = false;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (!isContainNullKey) {
                storageArray[FIRST_ROW_NUMBER][FIRST_COLUMNS_INDEX] = key;
                storageArray[FIRST_ROW_NUMBER][SECOND_COLUMNS_INDEX] = value;
                isContainNullKey = true;
            } else {
                storageArray[FIRST_ROW_NUMBER][SECOND_COLUMNS_INDEX] = value;
            }
        } else {
            int index = getNotNullKeyIndex(key);
            if (index != -1) {
                storageArray[index][SECOND_COLUMNS_INDEX] = value;
            } else {
                resizeArray();
                storageArray[storageArray.length - 1][FIRST_COLUMNS_INDEX] = key;
                storageArray[storageArray.length - 1][SECOND_COLUMNS_INDEX] = value;
            }
        }
    }

    private int getNotNullKeyIndex(K key) {
        for (int rowIndex = 0; rowIndex < storageArray.length; rowIndex++) {
            if (storageArray[rowIndex][FIRST_COLUMNS_INDEX] != null
                    && storageArray[rowIndex][FIRST_COLUMNS_INDEX].equals(key)) {
                return rowIndex;
            }
        }
        return -1;
    }

    private void resizeArray() {
        int nextRowIndex = storageArray.length + 1;
        Object[][] newArray = new Object[nextRowIndex][TOTAL_COLUMNS_NUMBER];
        System.arraycopy(storageArray, START_ARRAY_COPY_POSITION, newArray,
                START_ARRAY_COPY_POSITION, storageArray.length);
        storageArray = newArray;
    }

    @Override
    public V get(K key) {
        for (int rowIndex = 0; rowIndex < storageArray.length; rowIndex++) {
            if (key == null && storageArray[rowIndex][FIRST_COLUMNS_INDEX] == null) {
                return (V) storageArray[rowIndex][SECOND_COLUMNS_INDEX];
            } else if (storageArray[rowIndex][FIRST_COLUMNS_INDEX] != null
                    && storageArray[rowIndex][FIRST_COLUMNS_INDEX].equals(key)) {
                return (V) storageArray[rowIndex][SECOND_COLUMNS_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int arraySize = 0;
        if (isContainNullKey) {
            arraySize++;
        }
        for (int rowIndex = 0; rowIndex < storageArray.length; rowIndex++) {
            if (storageArray[rowIndex][FIRST_COLUMNS_INDEX] != null) {
                arraySize++;
            }
        }
        return arraySize;
    }
}
