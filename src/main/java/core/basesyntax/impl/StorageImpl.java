package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_SIZE];
        this.values = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areEqual(keys[i], key)) {
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
        for (int i = 0; i < keys.length; i++) {
            if (areEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean areEqual(Object key1, Object key2) {
        if (key1 == key2) {
            return true;
        } else if (key1 == null || key2 == null) {
            return false;
        }
        return key1.equals(key2);
    }
}
