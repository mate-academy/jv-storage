package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    public int getSize() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < getSize(); i++) {
            if (areKeysEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        values[getSize()] = value;
        keys[getSize()] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < getSize(); i++) {
            if (areKeysEqual(key,keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEqual(K newKey, K currentKey) {
        return (currentKey == newKey || (currentKey != null && currentKey.equals(newKey)));
    }
}
