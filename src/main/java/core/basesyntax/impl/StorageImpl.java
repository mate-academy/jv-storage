package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int DEFAULT_CAPACITY = 10;
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) { // key = null value = fjk
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
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
            if (key == keys[i] || keys[i] != null && keys[i].equals(key)) {
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
