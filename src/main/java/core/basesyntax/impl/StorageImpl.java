package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int DEFAULT_INDEX = 0;
    private static final int NUMBER_ONE = 1;
    private final Object[] keys = new Object[INITIAL_CAPACITY];
    private final Object[] values = new Object[INITIAL_CAPACITY];
    private int indexCounter = 1;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            values[DEFAULT_INDEX] = value;
            return;
        }
        for (int i = NUMBER_ONE; i < indexCounter; i++) {
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
        for (int i = NUMBER_ONE; i <= indexCounter; i++) {
            if (key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        if (keys[NUMBER_ONE] == null && values[DEFAULT_INDEX] != null) {
            return NUMBER_ONE;
        }
        return indexCounter - NUMBER_ONE;
    }
}
