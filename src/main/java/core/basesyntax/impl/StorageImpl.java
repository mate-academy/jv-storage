package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkKey(key, i)) {
                this.values[i] = value;
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
            if (checkKey(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    private boolean checkKey(K key, int i) {
        return key == keys[i] || (key != null && key.equals(keys[i]));
    }

    @Override
    public int size() {
        return size;
    }
}
