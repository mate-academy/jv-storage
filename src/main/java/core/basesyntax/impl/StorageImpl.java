package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_NUMBER];
        values = new Object[MAX_ARRAY_NUMBER];
    }

    @Override
    public void put(K key, V value) {

        if (size > MAX_ARRAY_NUMBER) {
            throw new RuntimeException("Arrays are full");
        }

        for (int i = 0; i < size; i++) {
            K current = (K) keys[i];
            if ((key == current) || (key != null && key.equals(current))) {
                values[i] = value;
                return;
            }
        }

        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
