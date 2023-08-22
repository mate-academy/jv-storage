package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ATTEMPTS = 10;
    private final K [] keys;
    private final V [] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ATTEMPTS];
        values = (V[]) new Object[MAX_ATTEMPTS];
    }

    @Override
    public void put(K key, V value) {
        if (size == MAX_ATTEMPTS) {
            return;
        }
        int index = getKeyIndex(key);
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
        int index = getKeyIndex(key);
        return index == -1 ? null : values[index];
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
