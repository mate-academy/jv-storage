package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = ((K[]) new Object[MAX_VALUE]);
        values = ((V[]) new Object[MAX_VALUE]);
    }

    @Override
    public void put(K key, V value) {
        int keySize = getSize(key);
        if (keySize == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keySize] = value;
        }
    }

    @Override
    public V get(K key) {
        int keySize = getSize(key);
        if (keySize != -1) {
            return values[keySize];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getSize(K key) {
        for (int i = 0; i < size; i++) {
            K keyArrays = keys[i];
            if (keyArrays == key || keyArrays != null && keyArrays.equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
