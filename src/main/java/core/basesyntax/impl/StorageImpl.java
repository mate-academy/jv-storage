package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
        } else if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (key == keys[i] || key != null && key.equals(keys[i])) {
                    return i;
                }
            } else if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
