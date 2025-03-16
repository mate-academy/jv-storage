package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int capacity;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        capacity = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[capacity] = key;
        values[capacity] = value;
        capacity++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return capacity;
    }

    private int getIndex(K key) {
        for (int i = 0; i < capacity; i++) {
            if ((key == keys[i]) || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
