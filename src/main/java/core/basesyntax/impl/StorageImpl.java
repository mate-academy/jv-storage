package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || ((keys[i] != null) && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
