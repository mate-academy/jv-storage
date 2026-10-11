package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keys = new Object[MAX_SIZE];
    private final Object[] values = new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

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

    private boolean keysEqual(Object first, Object second) {
        return first == null ? second == null : first.equals(second);
    }
}
