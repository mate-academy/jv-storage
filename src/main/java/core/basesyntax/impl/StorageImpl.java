package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private final Object[] values;
    private final Object[] keys;

    public StorageImpl() {
        values = new Object[MAX_NUMBER_OF_ELEMENTS];
        keys = new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
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

    @Override
    public int size() {
        return size;
    }

    private boolean areKeysEqual(Object firstKey, Object secondKey) {
        return firstKey == null && secondKey == null
                || firstKey != null && firstKey.equals(secondKey);
    }
}
