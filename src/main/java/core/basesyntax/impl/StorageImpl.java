package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;

    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[STORAGE_CAPACITY];
        this.values = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[size] = key;
        values[size++] = value;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1
                ? null
                : values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkEquals(K key1, K key2) {
        return key1 == key2
                || (key1 != null && key1.equals(key2));
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (checkEquals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
