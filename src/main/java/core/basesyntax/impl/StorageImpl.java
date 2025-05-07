package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int INVALID_INDEX = -1;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            updatePair(key, value);
        } else {
            addPair(key, value);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getEqualKeyIndex(key);
        return (index != INVALID_INDEX)
                ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getEqualKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keysAreEqual(key, i)) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    private void addPair(K key, V value) {
        values[size] = value;
        keys[size] = key;
        size++;
    }

    private void updatePair(K key, V value) {
        int index = getEqualKeyIndex(key);
        values[index] = value;
    }

    private boolean keysAreEqual(K key, int i) {
        return (key == keys[i])
                || (key != null && key.equals(keys[i]));
    }
}
