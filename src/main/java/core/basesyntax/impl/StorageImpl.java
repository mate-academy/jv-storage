package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    private static final int START_INDEX = 0;
    private static final int NO_MATCH_INDEX = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_LENGTH];
        values = (V[]) new Object[MAX_ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexForPutting(key);
        if (index == NO_MATCH_INDEX) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        return getIndexForPutting(key) == NO_MATCH_INDEX ? null
                : values[getIndexForPutting(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexForPutting(K key) {
        for (int i = START_INDEX; i < size; i++) {
            if ((key == keys[i]) || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return NO_MATCH_INDEX;
    }
}


