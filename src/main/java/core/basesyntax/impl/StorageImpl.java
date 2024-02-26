package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final String FULL_ARRAY_EXCEPTION_MESSAGE = "The storage is full";
    private final K[] keys = (K[]) new Object[MAX_ARRAY_SIZE];
    private final V[] values = (V[]) new Object[MAX_ARRAY_SIZE];
    private int size;

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareProvidedKey(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_ARRAY_SIZE && !containsKey(key)) {
            throw new IllegalStateException(FULL_ARRAY_EXCEPTION_MESSAGE);
        }
        for (int i = 0; i < size; i++) {
            if (compareProvidedKey(key, i)) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareProvidedKey(K key, int index) {
        return ((key == keys[index]) || (key != null && key.equals(keys[index])));
    }

    private boolean containsKey(K key) {
        for (K storedKey : this.keys) {
            if (storedKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
