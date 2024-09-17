package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[])new Object[STORAGE_MAX_SIZE];
        values = (V[])new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareKeys(keys[i], key)) {
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
            if (compareKeys(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean compareKeys(Object key1, Object key2) {
        return (key1 == key2 || key1 != null && key1.equals(key2));
    }

    @Override
    public int size() {
        return size;
    }
}
