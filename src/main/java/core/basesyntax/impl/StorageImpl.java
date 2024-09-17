package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];

        values = (V[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int foundKey = getIndex(key);
        if (foundKey == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[foundKey] = value;
        }
    }

    private int getIndex(K key) {
        int foundKey = -1;
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                foundKey = i;
                break;
            }
        }
        return foundKey;
    }

    @Override
    public V get(K key) {
        int foundKey = getIndex(key);
        if (foundKey == -1) {
            return null;
        } else {
            return values[foundKey];
        }
    }

    @Override
    public int size() {
        return size;
    }
}
