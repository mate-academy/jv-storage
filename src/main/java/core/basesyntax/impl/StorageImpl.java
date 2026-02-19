package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;

    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_ARRAY_SIZE];
        this.values = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_ARRAY_SIZE) {
            return;
        }

        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysEqual(Object storedKey, Object keyToCompare) {
        return storedKey == null ? keyToCompare == null : storedKey.equals(keyToCompare);
    }
}
