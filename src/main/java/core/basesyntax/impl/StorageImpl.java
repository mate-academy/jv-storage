package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null) || key != null && key.equals(keys[i])) {
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
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }
}
