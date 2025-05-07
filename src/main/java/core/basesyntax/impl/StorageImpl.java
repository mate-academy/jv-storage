package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index < 0) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || ((key != null) && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
