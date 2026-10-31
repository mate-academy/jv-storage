package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[10];
        this.values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (size < 10) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (this.keys[i] == key) {
                return value[i];
            }
        }
    }

    @Override
    public int size() {
        return size;
    }
}
