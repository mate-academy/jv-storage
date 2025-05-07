package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_SIZE];
        values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isKeysEqual(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeysEqual(K keyOne, K keyTwo) {
        return keyOne == keyTwo || keyOne != null && keyOne.equals(keyTwo);
    }
}
