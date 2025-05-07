package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int lastPosition = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ARRAY_SIZE];
        values = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[lastPosition] = key;
        values[lastPosition] = value;
        lastPosition++;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return lastPosition;
    }

    public int indexOf(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
