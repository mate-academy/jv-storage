package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = ((K[]) new Object[CAPACITY]);
        values = ((V[]) new Object[CAPACITY]);
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = keyIndex(key);
        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = keyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            K storedKey = keys[i];
            if (storedKey != null && storedKey.equals(key) || storedKey == key) {
                return i;
            }
        }
        return -1;
    }
}
