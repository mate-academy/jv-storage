package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int storageSize;
    private final K[] keyArray;
    private final V[] valueArray;

    public StorageImpl() {
        storageSize = 0;
        keyArray = (K[]) new Object[DEFAULT_CAPACITY];
        valueArray = (V[]) new Object[DEFAULT_CAPACITY];
    }

    private int getIndexOfKey(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (keyArray[i] == null ? key == null : keyArray[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (getIndexOfKey(key) != -1) {
            valueArray[getIndexOfKey(key)] = value;
        } else if (storageSize < DEFAULT_CAPACITY) {
            keyArray[storageSize] = key;
            valueArray[storageSize++] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getIndexOfKey(key) != -1) {
            return valueArray[getIndexOfKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
