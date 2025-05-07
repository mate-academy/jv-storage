package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_NUMBER];
        values = (V[]) new Object[MAX_ARRAY_NUMBER];
    }

    private int checkKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || keys[i] == key) {
                return i;
            }
        }
        return size;
    }

    @Override
    public void put(K key, V value) {
        int index = checkKey(key);
        keys[index] = key;
        values[index] = value;
        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        return values[checkKey(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
