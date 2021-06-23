package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_STORAGE_SIZE = 10;
    private int storageSize;
    private V[] valueStorage;
    private K[] keyStorage;

    public StorageImpl() {
        valueStorage = (V[]) new Object[MAXIMUM_STORAGE_SIZE];
        keyStorage = (K[]) new Object[MAXIMUM_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keyStorage[i] == key || (keyStorage[i] != null && keyStorage[i].equals(key))) {
                valueStorage[i] = value;
                return;
            }
        }
        valueStorage[storageSize] = value;
        keyStorage[storageSize] = key;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (keyStorage[i] == key || (keyStorage[i] != null && keyStorage[i].equals(key))) {
                return valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
