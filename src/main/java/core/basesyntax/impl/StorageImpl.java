package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysAreEquals(key, keys[i])) {
                keys[i] = key;
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
            if (keysAreEquals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    private boolean keysAreEquals(K key1, K key2) {
        return (key1 == key2) || (key2 != null && key2.equals(key1));
    }

    @Override
    public int size() {
        return size;
    }
}
