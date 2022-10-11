package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 11;
    private static final int START_INDEX = 1;
    private static final int UNEXPECTED_KEY = -1;
    private final K[] keys;
    private final V[] values;
    private int size = 1;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int i = indexOFkey(key);
        if (i != UNEXPECTED_KEY) {
            if (key == null && value != null) {
                values[i] = value;
                return;
            }
            if (key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (indexOFkey(key) != UNEXPECTED_KEY) {
            return values[indexOFkey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        if (keys[1] == null && values[0] != null) {
            return size;
        }
        return size - START_INDEX;
    }

    private int indexOFkey(K key) {
        if (key != null) {
            for (int i = START_INDEX; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
            return UNEXPECTED_KEY;
        }
        return 0;
    }
}
