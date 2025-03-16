package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_NUMBER_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;
    private int storageSize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[storageSize] = key;
        values[storageSize] = value;
        storageSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
