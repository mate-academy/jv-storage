package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAXIMUM_CAPACITY];
        values = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        V v = extracted(key);
        v = value;
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        return extracted(key);
    }
    private V extracted(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
