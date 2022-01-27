package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size = 0;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_SIZE];
        valuesArray = (V[]) new Object[MAX_SIZE];
    }

    private int getKeyIndex(K key) {
        if (key != null) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (key.equals(keysArray[i])) {
                    return i;
                }
            }
            return -1;
        } else {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (keysArray[i] == null) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public void put(K key, V value) {
        int indexOfKey = getKeyIndex(key);
        if (key != null) {
            if (indexOfKey < 0) {
                if (size() <= MAX_SIZE) {
                    keysArray[size] = key;
                    valuesArray[size] = value;
                    size++;
                } else {
                    throw new RuntimeException("This storage is full!");
                }
            } else {
                valuesArray[indexOfKey] = value;
            }
        } else {
            if (storageWithNullKeyExist(indexOfKey)) {
                valuesArray[indexOfKey] = value;
            } else {
                valuesArray[indexOfKey] = value;
                size++;
            }
        }
    }

    private boolean storageWithNullKeyExist(int indexOfKey) {
        return valuesArray[indexOfKey] != null ? true : false;
    }

    @Override
    public V get(K key) {
        int indexOfKey = getKeyIndex(key);
        if (indexOfKey >= 0) {
            return valuesArray[indexOfKey];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
