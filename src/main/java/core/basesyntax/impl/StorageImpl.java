package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int KEY_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    public static final int MAX_ELEMENTS = 10;
    public static final int PAIR_LIMIT = 2;
    private int dynamicStorageSize;
    private final Object[][] arrayOfPairs;

    public StorageImpl() {
        arrayOfPairs = new Object[MAX_ELEMENTS][PAIR_LIMIT];
    }

    @Override
    public void put(K key, V value) {
        boolean exists = false;
        for (int i = 0; i <= dynamicStorageSize; i++) {
            if ((key == arrayOfPairs[i][KEY_INDEX]
                    || key != null && key.equals(arrayOfPairs[i][KEY_INDEX]))) {
                if (arrayOfPairs[i][VALUE_INDEX] != null) {
                    arrayOfPairs[i][VALUE_INDEX] = value;
                    exists = true;
                }
            }
        }
        if (!exists) {
            arrayOfPairs[dynamicStorageSize][KEY_INDEX] = key;
            arrayOfPairs[dynamicStorageSize][VALUE_INDEX] = value;
            dynamicStorageSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= dynamicStorageSize; i++) {
            if (key == arrayOfPairs[i][KEY_INDEX]
                    || key != null && key.equals(arrayOfPairs[i][KEY_INDEX])) {
                return (V) arrayOfPairs[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return dynamicStorageSize;
    }
}
