package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (MAX_NUMBER_OF_ELEMENTS > storageSize) {
            keys[storageSize] = key;
            values[storageSize] = value;
            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return storageSize;
    }

    private int getIndex(K key) {
        for (int i = 0; i < storageSize; i++) {
            if ((keys[i] == key) || ((keys[i] != null) && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
