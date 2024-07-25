package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int arraySize;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ARRAY_LENGTH];
        valueArray = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (arraySize >= MAX_ARRAY_LENGTH) {
            throw new IllegalStateException("Storage is full. Maximum size is "
                    + MAX_ARRAY_LENGTH + " .");
        }
        saveOrUpdate(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            } else if (keyArray[i] == key && valueArray[i] != null) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }

    private void saveOrUpdate(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == valueArray[i]) {
                keyArray[i] = key;
                valueArray[i] = value;
                arraySize++;
                return;
            } else if (keyArray[i] == key || keyArray[i] != null
                    && keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
    }
}
