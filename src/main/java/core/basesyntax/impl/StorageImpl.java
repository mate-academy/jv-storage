package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_NUM = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_NUM];
        values = (V[]) new Object[MAX_STORAGE_NUM];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[keyIndex] = value;
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            K keyIndex = keys[i];
            if (keyIndex != null && keyIndex.equals(key)
                    || keyIndex == key) {
                return i;
            }
        }
        return -1;
    }
}
