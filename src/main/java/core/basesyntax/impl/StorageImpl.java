package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARR_SIZE = 10;
    private static final String ERROR_MESSAGE = "Can't store more than "
            + MAX_ARR_SIZE + "  elements";
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARR_SIZE];
        this.values = (V[]) new Object[MAX_ARR_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
        } else if (size < MAX_ARR_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println(ERROR_MESSAGE);
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
            if (checkKeys(i, key)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkKeys(int actualKey, K key) {
        K storedKey = keys[actualKey];
        if (storedKey == null) {
            return key == null;
        } else {
            return storedKey.equals(key);
        }
    }
}


