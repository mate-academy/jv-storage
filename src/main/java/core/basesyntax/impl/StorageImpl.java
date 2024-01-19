package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (size < MAX_ITEMS_NUMBER) {
            int index = findKeyIndex(key);
            if (index != -1) {
                values[index] = value;
            } else {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } else {
            System.out.println("The storage is full, it is impossible to make a new entry");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return (index != -1) ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (areKeysEqual(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean areKeysEqual(K key1, K key2) {
        return (key1 == null && key2 == null) || (key1 != null && key1.equals(key2));
    }
}
