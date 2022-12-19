package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_ELEMENT = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENT];
        values = (V[]) new Object[MAX_ELEMENT];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = index(key);
        keys[index] = key;
        values[index] = value;
        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        return values[index(key)];
    }

    @Override
    public int size() {
        return size;
    }

    private int index(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return size;
    }
}
