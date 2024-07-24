package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private final Object[] keyArray;
    private final Object[] valueArray;
    private int arraySize = 0;

    public StorageImpl() {
        keyArray = new Object[MAX_ARRAY_LENGTH];
        valueArray = new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (arraySize >= MAX_ARRAY_LENGTH) {
            throw new IllegalStateException("Storage is full. Maximum size is "
                    + MAX_ARRAY_LENGTH + " .");
        } else if (!updateValueByKey(key, value)) {
            addKeyPair(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return (V) valueArray[i];
            } else if (key == null && keyArray[i] == null && valueArray[i] != null) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }

    private void addKeyPair(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                arraySize++;
                return;
            }
        }
    }

    private boolean updateValueByKey(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                valueArray[i] = value;
                return true;
            } else if (keyArray[i] == null && valueArray[i] != null && key == null) {
                valueArray[i] = value;
                return true;
            }
        }
        return false;
    }
}
