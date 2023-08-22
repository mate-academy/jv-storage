package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private Object[] keysArray = new Object[MAX_ARRAY_SIZE];
    private Object[] valuesArray = new Object[MAX_ARRAY_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (updateExistingKey(key,value)) {
            if (size < MAX_ARRAY_SIZE) {
                keysArray[size] = key;
                valuesArray[size] = value;
                size++;
            } else {
                throw new RuntimeException("Array run out of memory");
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == null && key == null
                    || keysArray[i] != null && keysArray[i].equals(key)) {
                return (V) valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean updateExistingKey(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] != null && keysArray[i].equals(key)
                    || keysArray[i] == null && key == null) {
                valuesArray[i] = value;
                return false;
            }
        }
        return true;
    }
}
