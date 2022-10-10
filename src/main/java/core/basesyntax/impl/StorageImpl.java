package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NULL_SIZE = 1;
    private int count;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        count = 0;
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    public boolean checkValue(K key, int i) {
        if (key != null && key.equals(keys[i])) {
            return true;
        }
        return key == null && key == keys[i];
    }

    @Override
    public void put(K key, V value) {
        boolean putOrNot = false;
        for (int i = 0; i < keys.length; i++) {
            if (checkValue(key, i)) {
                values[i] = value;
                putOrNot = true;
            }
        }
        if (!putOrNot) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            count = NULL_SIZE;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (checkValue(key, i)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
