package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) != null) {
            for (int i = 0; i < size; i++) {
                if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                }
            }
        } else if (size < values.length) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Can't put the file into storage" + key + value);
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
