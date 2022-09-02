package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_NUMBER_ELEMENTS = 10;
    private final K[] keys = (K[]) new Object[MAX_NUMBER_ELEMENTS];
    private final V[] values = (V[]) new Object[MAX_NUMBER_ELEMENTS];
    private int storageSize;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageSize; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
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
        V value;
        for (int i = 0; i < storageSize; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                value = values[i];
                return value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
