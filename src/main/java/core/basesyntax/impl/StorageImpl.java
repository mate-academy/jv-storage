package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int counter;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean sameKey = false;
        int index = 0;
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(keys[i], key)) {
                sameKey = true;
                index = i;
            }
        }
        if (sameKey) {
            keys[index] = key;
            values[index] = value;
        } else {
            keys[counter] = key;
            values[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
