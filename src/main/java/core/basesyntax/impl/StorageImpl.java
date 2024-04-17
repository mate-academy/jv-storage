package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int size;
    private boolean nullKeyExists;

    public StorageImpl() {
        keys = (K[]) new Object [DEFAULT_CAPACITY];
        values = (V[]) new Object [DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                values[findIndex(keys, key)] = value;
                if (key == null && !nullKeyExists) {
                    size++;
                    nullKeyExists = true;
                }
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = findIndex(keys, key);
        if (index != -1) {
            return values[index];
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(K[] keys, K key) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
