package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            values[size] = value;
            keys[size] = key;
            size++;
            return;
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
