package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int WRONG_INDEX = -1;
    private static final int START_ITERATION = 0;
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != WRONG_INDEX) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != WRONG_INDEX ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = START_ITERATION; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return WRONG_INDEX;
    }
}
