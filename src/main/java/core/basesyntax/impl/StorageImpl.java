package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_ARRAY = 10;
    private final K [] keys;
    private final V [] values;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE_ARRAY];
        values = (V[]) new Object[MAX_SIZE_ARRAY];
    }

    private int getIndexForKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
     public void put(K key, V value) {
        int index = getIndexForKey(key);
        if (index == -1) {
            keys [size] = key;
            values [size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexForKey(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }
}

