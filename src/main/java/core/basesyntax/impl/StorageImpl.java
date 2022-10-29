package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_SIZE];
        values = (V[]) new Object[MAX_STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int i;
        for (i = 0; i < size; i++) {
            if (isKeysEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size += 1;
    }

    @Override
    public V get(K key) {
        int i;
        for (i = 0; i < size; i++) {
            if (isKeysEqual(key, keys[i])) {
                break;
            }
        }
        return values[i];
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isKeysEqual(K keyOne, K keyTwo) {
        return keyOne == null && keyTwo == null || keyOne != null && keyOne.equals(keyTwo);
    }
}
