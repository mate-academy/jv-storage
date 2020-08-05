package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_STORAGE = 10;
    private K[] tableOfKey;
    private V[] tableOfValue;
    private int arrayIndex = 0;

    public StorageImpl() {
        tableOfKey = (K[]) new Object[SIZE_OF_STORAGE];
        tableOfValue = (V[]) new Object[SIZE_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        int j = 0;
        for (j = 0; j < tableOfKey.length; j++) {
            if (tableOfKey[j] == key) {
                tableOfValue[j] = value;
                j = tableOfKey.length + 1;
            }
        }
        if (j == tableOfKey.length || key == null) {
            tableOfKey[arrayIndex] = key;
            tableOfValue[arrayIndex] = value;
            arrayIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int j = 0; j < tableOfKey.length; j++) {
            if (tableOfKey[j] == key || (key != null && key.equals(tableOfKey[j]))) {
                return (V) tableOfValue[j];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() == getClass()) {
            StorageImpl<K, V> storageImpl = (StorageImpl<K, V>) object;
            return ((tableOfKey == storageImpl.tableOfKey)
                    || (storageImpl.tableOfKey != null
                    && storageImpl.tableOfKey.equals(tableOfKey)))
                    && ((tableOfValue == storageImpl.tableOfValue)
                    || (storageImpl.tableOfValue != null
                    && storageImpl.tableOfValue.equals(tableOfValue)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        if (tableOfKey != null) {
            result += 31 * tableOfKey.hashCode();
        }
        if (tableOfValue != null) {
            result += 31 * tableOfKey.hashCode();
        }
        return result;
    }
}
