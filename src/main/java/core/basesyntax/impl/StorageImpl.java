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
        for (int i = 0; i < this.size; i++) {
            if (this.keys[i] != null) {
                if (this.keys[i].equals(key)) {
                    this.values[i] = value;
                    return;
                }
            }
        }
        if (this.size < 10) {
            this.keys[this.size] = key;
            this.values[this.size] = value;
            this.size++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (this.keys[i] != null) {
                if (this.keys[i].equals(key)) {
                    return this.values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
