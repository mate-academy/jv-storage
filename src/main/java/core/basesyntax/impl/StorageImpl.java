package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_PAIRS];
        this.values = (V[]) new Object[MAX_PAIRS];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < this.size; i++) {
            if (keysEqual(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        if (this.size == MAX_PAIRS) {
            throw new RuntimeException("Storage is full");
        }

        this.keys[this.size] = key;
        this.values[this.size] = value;
        this.size += 1;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.size; i++) {
            if (keysEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean keysEqual(K key1, K key2) {
        return (key1 == null) ? (key2 == null) : key1.equals(key2);
    }
}
