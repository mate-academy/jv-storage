package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (currentSize == keys.length - 1) {
            return;
        }

        Integer index = getIndex(key);
        if (null != index) {
            keys[index] = key;
            values[index] = value;
            if (currentSize == index) {
                currentSize++;
            }
        }

    }

    private Integer getIndex(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((null == key && null == keys[i]) || (null != key && key.equals(keys[i]))) {
                return i;
            }
        }
        return currentSize;
    }

    @Override
    public V get(K key) {
        Integer index = getIndex(key);
        return currentSize == index ? null : values[index];
    }

    @Override
    public int size() {
        return currentSize;
    }
}
