package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private int size = 0;
    private K[] keys = (K[]) new Object[MAX_ARRAY_LENGTH];
    private V[] values = (V[]) new Object[MAX_ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null || (key != null && key.equals(keys[i]))) {
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
            if (keys[i] == key || (keys[i]) != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int ValueCounter = 0;
        for (V value : values) {
            if (value != null) {
                ValueCounter++;
            }
        }
        return ValueCounter;
    }
}
