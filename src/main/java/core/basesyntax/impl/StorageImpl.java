package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_SIZE) {
            return;
        }
        int index = findKeyIndex(key);
        if (index == -1) {
            keys[this.size] = key;
            values[this.size] = value;
            this.size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isSameKey(key, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSameKey(K key, int index) {
        return (key == keys[index])
                || key != null && key.equals(keys[index]);
    }
}
