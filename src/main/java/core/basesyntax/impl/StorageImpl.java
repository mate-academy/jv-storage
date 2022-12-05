package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object [MAX_NUMBER];
        this.values = (V[]) new Object [MAX_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = index(key);
        keys[index] = key;
        values[index] = value;
        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        return values[index(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int index(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == null && key == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return size;
    }
}
