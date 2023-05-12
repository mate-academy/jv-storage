package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NOT_FOUND = -1;
    private int size;
    private final K[] keys;
    private final V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndex(key);
        if (index != NOT_FOUND) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return (index != NOT_FOUND) ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isMatching(key,i)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private boolean isMatching(K key, int index) {
        return (key == null) ? (keys[index] == null) : key.equals(keys[index]);
    }
}
