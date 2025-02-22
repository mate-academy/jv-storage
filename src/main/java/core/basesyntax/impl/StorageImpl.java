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
    }

    @Override
    public void put(K key, V value) {
        int index = index(key);
        if (index == -1) {
            index = size;
        }
        keys[index] = key;
        values[index] = value;
        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (index(key) == -1) {
            return null;
        } else {
            return values[index(key)];
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int index(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
