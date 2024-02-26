package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private static final String FULL_ARRAY_EXCEPTION_MESSAGE = "The storage is full. "
                                                             + "The max size is " + MAX_ARRAY_SIZE;
    private final K[] keys = (K[]) new Object[MAX_ARRAY_SIZE];
    private final V[] values = (V[]) new Object[MAX_ARRAY_SIZE];
    private int size;

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size == MAX_ARRAY_SIZE) {
                throw new IllegalStateException(FULL_ARRAY_EXCEPTION_MESSAGE);
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (compareProvidedKey(key, i)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareProvidedKey(K key, int index) {
        return ((key == keys[index]) || (key != null && key.equals(keys[index])));
    }
}
