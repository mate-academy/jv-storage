package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int ARRAYS_ARE_EMPTY = 0;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (canAddWithSameKey(key, value)) {
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (size == ARRAYS_ARE_EMPTY) {
            return null;
        }
        if (key != null) {
            for (int i = size; i >= 0; i--) {
                if (key.equals(keys[i - 1])) {
                    return (V) values[i - 1];
                }
            }
        }
        return (V) values[findValueWithNullKey(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private boolean canAddWithSameKey(K key, V value) {
        if (size != ARRAYS_ARE_EMPTY) {
            if (key != null) {
                if (key.equals(keys[size - 1])) {
                    keys[size - 1] = key;
                    values[size - 1] = value;
                    return true;
                }
            } else {
                if (keys[size - 1] == null) {
                    values[size] = value;
                    return true;
                }
            }
        }
        return false;
    }

    private int findValueWithNullKey(K key) {
        int index = size;
        for (int i = size - 1; i > 0; i--) {
            if (keys[i] == key & values[i] != null) {
                index = i;
                break;
            }
        }
        return index;
    }
}
