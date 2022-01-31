package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int value;
    private K[] key;
    private V[] values;

    public StorageImpl() {
        key = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.value; i++) {
            if (get(key) != null) {
                values[i] = value;
                return;
            }
        }
        this.key[this.value] = key;
        values[this.value] = value;
        this.value++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < value; i++) {
            if (this.key[i] == key || this.key[i] != null && this.key[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return value;
    }
}
