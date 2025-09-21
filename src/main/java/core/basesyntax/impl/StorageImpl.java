package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private static final int INITIAL_SIZE_OF_STORAGE = 0;

    private K[] keys;
    private V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
        values = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
        storageSize = INITIAL_SIZE_OF_STORAGE;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((keys[i] == null && key == null)) {
                return i;
            }
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) throws RuntimeException {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != - 1) {
            values[keyIndex] = value;
            return;
        }
        if (storageSize == MAX_ELEMENTS_IN_STORAGE) {
            throw new RuntimeException("Storage is full");
        } else {
            keys[storageSize] = key;
            values[storageSize] = value;
            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
