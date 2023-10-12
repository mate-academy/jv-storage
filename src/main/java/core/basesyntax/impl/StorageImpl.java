package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexForKey(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexForKey(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexForKey(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(i, key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean areKeysEqual(int i, K key) {
        return (key == keys[i] || key != null && key.equals(keys[i]));
    }
}
