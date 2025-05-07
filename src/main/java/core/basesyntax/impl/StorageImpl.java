package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putNullKey(value);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                values[i] = value;
                return;
            }
        }

        if (size == MAX_SIZE) {
            throw new StorageFullException("Storage is full. Cannot add more items.");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getNullKey();
        }

        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void putNullKey(V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                values[i] = value;
                return;
            }
        }

        try {
            if (size < MAX_SIZE) {
                keys[size] = null;
                values[size] = value;
                size++;
            } else {
                throw new StorageFullException("Storage is full. Cannot add more items.");
            }
        } catch (StorageFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private V getNullKey() {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean areKeysEqual(K key1, Object key2) {
        return key1 == null ? key2 == null : key1.equals(key2);
    }
}
