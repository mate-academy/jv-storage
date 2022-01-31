package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_SIZE = 10;
    private int size;
    private K[] key;
    private V[] values;

    public StorageImpl() {
        key = (K[]) new Object[MAXIMUM_SIZE];
        values = (V[]) new Object[MAXIMUM_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.size; i++) {
            if (get(key) != null) {
                values[i] = value;
                return;
            }
        }
        if (get(key) == null) {
            this.key[this.size] = key;
            values[this.size] = value;
            this.size++;
        } else {
            values[this.size - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
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
