package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int DEFAULT_INDEX = 0;
    private static final int INITIAL_INDEX = 1;
    private final Object[] keys = new Object[INITIAL_CAPACITY];
    private final Object[] values = new Object[INITIAL_CAPACITY];
    private int indexCounter = 1;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            values[DEFAULT_INDEX] = value;
            return;
        }
        for (int i = INITIAL_INDEX; i < indexCounter; i++) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[indexCounter] = key;
        values[indexCounter++] = value;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return (V) values[DEFAULT_INDEX];
        }
        for (int i = INITIAL_INDEX; i <= indexCounter; i++) {
            if (key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (keys[INITIAL_INDEX] == null && values[DEFAULT_INDEX] != null) {
            return INITIAL_INDEX;
        }
        return indexCounter - INITIAL_INDEX;
    }
}
