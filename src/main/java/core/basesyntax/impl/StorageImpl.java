package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX];
        values = (V[]) new Object[MAX];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX) {
            keys[size] = key;
            values[size] = (V) value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
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
