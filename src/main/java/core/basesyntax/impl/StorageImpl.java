package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ROWS_NUMBER = 10;
    private static final int MAX_COLUMN_NUMBER = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] keyValuePairs;
    private int storageSize;

    public StorageImpl() {
        this.keyValuePairs = new Object[MAX_ROWS_NUMBER][MAX_COLUMN_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        boolean keyIsNew = true;
        for (int i = 0; i < storageSize; i++) {
            if (compareObjects(keyValuePairs[i][KEY_INDEX], key)) {
                keyValuePairs[i][VALUE_INDEX] = value;
                keyIsNew = false;
                break;
            }
        }
        if (isStorageFull()) {
            throw new RuntimeException("Storage is full! Can't add key: "
                    + key + ", value: " + value);
        }
        if (keyIsNew) {
            keyValuePairs[storageSize][KEY_INDEX] = key;
            keyValuePairs[storageSize][VALUE_INDEX] = value;
            storageSize++;
        }
    }

    private boolean isStorageFull() {
        return storageSize == MAX_ROWS_NUMBER;
    }

    private boolean compareObjects(Object obj1, Object obj2) {
        return (obj1 == obj2) || obj1 != null && obj1.equals(obj2);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (compareObjects(keyValuePairs[i][KEY_INDEX], key)) {
                return (V) keyValuePairs[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
