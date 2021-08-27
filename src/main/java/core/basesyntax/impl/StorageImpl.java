package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private final K[] keys;
    private final V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
    }

    private boolean keysEquals(K keyOne, K keyTwo) {
        return keyTwo == keyOne || keyOne != null && keyOne.equals(keyTwo);
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_VALUE) {
            throw new RuntimeException("Exceeded the limit");
        }
        for (int i = 0; i < size; i++) {
            if (keysEquals(key, keys[i])) {
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
            if (keysEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
