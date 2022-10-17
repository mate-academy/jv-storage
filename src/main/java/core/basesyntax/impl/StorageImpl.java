package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private static final int NEGATIVE_INDEX = -1;
    private K[] keys;
    private V[] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_SIZE];
        values = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (keyCheck(key) != NEGATIVE_INDEX) {
            values[keyCheck(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return (keyCheck(key) == NEGATIVE_INDEX) ? null : values[keyCheck(key)];
    }

    @Override
    public int size() {
        return size;
    }

    public int keyCheck(K key) {
        int result = NEGATIVE_INDEX;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                result = i;
            }
        }
        return result;
    }
}
