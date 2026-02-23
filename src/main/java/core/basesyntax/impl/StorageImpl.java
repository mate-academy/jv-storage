package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int CAPACITY = 10;

    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);

        if (index != -1) {
            values[index] = value;
            return;

        }

        if (size < CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index == -1 ? null : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (isEqual(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEqual(K k1, K k2) {
        return k1 == null ? k2 == null : k1.equals(k2);
    }
}
