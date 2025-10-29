package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int index;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
        index = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (checkKey(i, key)) {
                values[i] = value;
                return;
            }
        }

        if (index != ARRAY_SIZE) {
            keys[index] = key;
            values[index] = value;
            index++;
        }
    }

    public boolean checkKey(int i, K key) {
        return (keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key));
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (checkKey(i, key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
