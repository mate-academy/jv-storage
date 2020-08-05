package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_STORAGE = 10;
    private K[] tableOfKey;
    private V[] tableOfValue;
    private int arrayIndex;

    public StorageImpl() {
        tableOfKey = (K[]) new Object[SIZE_OF_STORAGE];
        tableOfValue = (V[]) new Object[SIZE_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int j = 0;
        for (j = 0; j < arrayIndex; j++) {
            if (tableOfKey[j] == key || (key != null && key.equals(tableOfKey[j]))) {
                tableOfValue[j] = value;
                return;
            }
        }
        tableOfKey[arrayIndex] = key;
        tableOfValue[arrayIndex] = value;
        arrayIndex++;
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < arrayIndex; j++) {
            if (tableOfKey[j] == key
                    || (key != null && key.equals(tableOfKey[j]))) {
                return (V) tableOfValue[j];
            }
        }
        return null;
    }
}
