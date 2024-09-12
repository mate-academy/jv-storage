package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private int arraySize = 0;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_STORAGE_LENGTH];
        this.valueArray = (V[]) new Object[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[arraySize] = key;
        valueArray[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < arraySize; i++) {
            if (key == keyArray[i] || key != null && key.equals(keyArray[i])) {
                value = valueArray[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
