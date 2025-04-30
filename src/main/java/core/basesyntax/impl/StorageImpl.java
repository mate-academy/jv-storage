package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int CAPACITY = 10;
    public static final int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;


    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size == CAPACITY) {
            return;
        }
        int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            values[keyIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = findKeyIndex(key);
        return keyIndex == -1 ? null : values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
