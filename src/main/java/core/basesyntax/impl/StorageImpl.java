package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int STORAGE_ARRAYS_LENGTH = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_ARRAYS_LENGTH];
        this.values = (V[]) new Object[STORAGE_ARRAYS_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = indexOf(key);
        if (contains(key)) {
            values[keyIndex] = value;
        } else {
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = indexOf(key);
        if (!contains(key)) {
            return null;
        } else {
            return values[keyIndex];
        }
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }

    private boolean contains(K key) {
        return indexOf(key) >= 0;
    }

    @Override
    public int size() {
        return size;
    }
}
