package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    K[] keys;
    V[] values;
    int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_SIZE) {
            if (key == null) {
                for (int i = 0; i < size; i++) {
                    if (keys[i] == null) {
                        values[i] = value;
                        return;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (key.equals(keys[i])) {
                        values[i] = value;
                        return;
                    }
                }
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keys[i])) || (keys[i] == null && key == null)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
