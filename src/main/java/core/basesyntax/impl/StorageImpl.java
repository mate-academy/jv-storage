package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEM_NUMBER = 10;
    private final K [] keys;
    private final V [] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEM_NUMBER];
        values = (V[]) new Object[MAX_ELEM_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size++] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
