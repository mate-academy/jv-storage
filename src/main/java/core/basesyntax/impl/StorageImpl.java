package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE = 0;
    private static final int CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        size = INITIAL_SIZE;
    }

    @Override
    public void put(K key, V value) {
        boolean noEqualsElement = true;
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || key != null && key.equals(keys[i])) {
                values[i] = value;
                noEqualsElement = false;
            }
        }
        if (noEqualsElement) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && keys[i] != null && (key.equals(keys[i]))) {
                return values[i];
            } else if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
