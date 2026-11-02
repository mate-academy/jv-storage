package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys = (K[]) new Object[MAX_CAPACITY];
    private V[] values = (V[]) new Object[MAX_CAPACITY];
    private int size = 0;

    // public StorageImpl() {
    // this.keys = (K[]) new Object[MAX_CAPACITY];
    // this.values = (V[]) new Object[MAX_CAPACITY];
    // }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.size; i++) {
            if (this.keys[i] == key) {
                this.values[i] = value;
                return;
            }
            if (this.keys[i] != null) {
                if (this.keys[i].equals(key)) {
                    this.values[i] = value;
                    return;
                }
            }
        }
        if (this.size < MAX_CAPACITY) {
            this.keys[this.size] = key;
            this.values[this.size] = value;
            this.size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (this.keys[i] == key) {
                return this.values[i];
            }
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
