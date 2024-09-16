package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    @SuppressWarnings("unchecked")
    private final K[] keys = (K[]) new Object[MAX_SIZE];
    @SuppressWarnings("unchecked")
    private final V[] values = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            boolean isKeyNullAndMatch = (key == null && keys[i] == null);
            boolean isKeyNonNullAndMatch = (key != null && key.equals(keys[i]));
            if (isKeyNullAndMatch || isKeyNonNullAndMatch) {
                return i;
            }
        }
        return -1;
    }
}
