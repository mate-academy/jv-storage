package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private int storageSize = 0;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = new Object[STORAGE_CAPACITY];
        valueArray = new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keyArray[i] == null && valueArray[i] != null) {
                continue;
            }
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                storageSize++;
                return;
            }
        }
        keyArray[storageSize] = key;
        valueArray[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((key == null && keyArray[i] == null)
                    || (keyArray[i] != null && keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }
}
