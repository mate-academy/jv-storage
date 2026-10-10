package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEM_NUMBER = 10;
    private static final int INDEX_ELEM_DOES_NOT_EXISTS = -1;
    private int counter = 0;
    private K[] keys;
    private V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEM_NUMBER];
        values = (V[]) new Object[MAX_ELEM_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);

        if (index != INDEX_ELEM_DOES_NOT_EXISTS) {
            values[index] = value;
        } else {
            keys[counter] = key;
            values[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);

        if (index != INDEX_ELEM_DOES_NOT_EXISTS) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }

    private int getIndex(K key) {
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return INDEX_ELEM_DOES_NOT_EXISTS;
    }
}
