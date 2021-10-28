package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_AMOUNT = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_AMOUNT];
        values = (V[]) new Object[MAX_AMOUNT];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) >= 0) {
            values[indexOf(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        if (indexOf(key) >= 0) {
            return values[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
