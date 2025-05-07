package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key,keys[i])) {
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
            if (areKeysEqual(key, keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    private boolean areKeysEqual(Object firstKey, Object secondKey) {
        return firstKey == null && secondKey == null
                || firstKey != null && firstKey.equals(secondKey);
    }

    @Override
    public int size() {
        return size;
    }
}
