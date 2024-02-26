package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INDEX_NOT_FOUND = -1;

    private final K[] keys;
    private final V[] values;

    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index == INDEX_NOT_FOUND) {
            add(key, value);
            return;
        }
        replace(value, index);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == INDEX_NOT_FOUND
                ? null
                : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void replace(V value, int index) {
        values[index] = value;
    }

    private void add(K key, V value) {
        if (size == MAX_SIZE) {
            throw new IllegalArgumentException(
                    "The size of storage is bigger than max size "
                    + MAX_SIZE + "!");
        }

        values[size] = value;
        keys[size] = key;
        size++;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEquals(key, keys[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    private boolean areKeysEquals(K key, K otherKey) {
        return ((otherKey == null && key == null)
                || (otherKey != null && otherKey.equals(key)));
    }
}
