package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            values[size] = value;
            keys[size] = key;
            size++;
        }
        values[getIndex(key)] = value;
    }

    public int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        if (getIndex(key) != -1) {
            return values[getIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
