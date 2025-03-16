package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private static final int INDEX_NOT_FOUND = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_STORAGE];
        values = (V[]) new Object[MAX_SIZE_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        if (!contains(key)) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[indexOf(key)] = value;
    }

    @Override
    public V get(K key) {
        if (contains(key)) {
            return values[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || key == keys[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    private boolean contains(K key) {
        return indexOf(key) >= 0;
    }
}
