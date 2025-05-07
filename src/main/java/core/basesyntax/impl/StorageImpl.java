package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private static final int INDEX_UNEXIST_KEY = -1;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != INDEX_UNEXIST_KEY) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index == INDEX_UNEXIST_KEY ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return INDEX_UNEXIST_KEY;
    }
}
