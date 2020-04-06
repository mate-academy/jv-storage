package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        index = 0;
        keys = (K[]) new Object[LENGTH];
        values = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        if (findConformity(key) == -1) {
            keys[index] = key;
            values[index] = value;
            index++;
        } else {
            values[findConformity(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        return findConformity(key) == -1 ? null : values[findConformity(key)];
    }

    private int findConformity(K key) {
        int number = -1;
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                number = i;
            }
        }
        return number;
    }
}
