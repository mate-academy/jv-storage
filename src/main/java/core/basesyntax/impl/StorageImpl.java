package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_PAIRS_NUMBER = 10;
    private int size;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_PAIRS_NUMBER];
        values = new Object[MAX_PAIRS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int index = 0; index < size; index++) {
            if ((keys[index] == key) || (keys[index] != null
                    && keys[index].equals(key))) {
                values[index] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < size(); index++) {
            if ((keys[index] == key) || (keys[index] != null
                    && keys[index].equals(key))) {
                return (V) values[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
