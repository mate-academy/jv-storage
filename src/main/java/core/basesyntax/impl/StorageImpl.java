package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARRAY_NUMBER];
        this.values = (V[]) new Object[MAX_ARRAY_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || keys[i] == key) {
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
        V value = null;
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || keys[i] == key) {
                value = values[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

}
