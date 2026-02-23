package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;

    private K[] keys = (K[]) new Object[MAX_SIZE];
    private V[] values = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);

        if (index != -1) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {

            if (keys[i] == null) {
                if (key == null) {
                    return i;
                }
            } else {
                if (keys[i].equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}


