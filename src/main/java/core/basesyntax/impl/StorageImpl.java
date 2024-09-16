package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
