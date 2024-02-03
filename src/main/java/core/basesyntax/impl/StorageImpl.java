package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ROW_COUNT = 10;
    private static final int COLUMN_COUNT = 2;
    private static final int INITIAL_VALUE = 0;
    private Object[][] storageArray;

    public StorageImpl() {
        storageArray = new Object[ROW_COUNT][COLUMN_COUNT];
    }

    @Override
    public void put(K key, V value) {
        if (key != null && value != null) {
            for (int i = 0; i < storageArray.length; i++) {
                if ((storageArray[i][0] == null) || storageArray[i][0].equals(key)) {
                    storageArray[i][0] = key;
                    storageArray[i][1] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int number = 0;
        for (int i = 0; i < storageArray.length; i++) {
            if (key.equals(storageArray[i][0]) || (key == null && storageArray[i][0] == null)) {
                number = i;
                return (V) storageArray[i][1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i][0] == null && storageArray[i][1] == null) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
