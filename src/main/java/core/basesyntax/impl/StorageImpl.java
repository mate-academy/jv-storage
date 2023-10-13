package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_VALUE];
        this.values = (V[]) new Object[MAX_VALUE];
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, i)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_VALUE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyEquals(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean keyEquals(K key, int i) {
        return (key == keys[i] || (key != null && key.equals(keys[i])));
    }

    @Override
    public int size() {
        return size;
    }
}
