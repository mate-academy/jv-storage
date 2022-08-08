package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private K [] keys;
    private V [] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STORAGE_CAPACITY];
        values = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndex(key);
        if (keyIndex != -1) {
            keys[keyIndex] = key;
            values[keyIndex] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndex(key);
        if (keyIndex == -1) {
            return null;
        }
        return values[keyIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
