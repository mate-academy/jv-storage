package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                size++;
                break;
            }
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
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
