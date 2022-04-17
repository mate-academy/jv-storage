package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[])new Object[MAX_CAPACITY];
        values = (V[])new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i] == null && values[i] != null
                    || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            if (key == keys[i] && keys[i] == null && values[i] == null) {
                values[i] = value;
                size++;
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
            if (key == null && key == keys[i] || key != null && key.equals(keys[i])) {
                value = values[i];
                break;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}
