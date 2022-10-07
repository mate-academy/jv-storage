package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final String STORAGE_IS_FULL = "The storage is full";
    public static final int CAPACITY = 10;

    private final Object[] keys;
    private final Object[] values;
    private int tail = 0;

    public StorageImpl() {
        keys = new Object[CAPACITY];
        values = new Object[CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            index = tail;
            tail++;
        }
        try {
            keys[index] = key;
            values[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(STORAGE_IS_FULL, e);
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return tail;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size(); i++) {
            Object nextKey = keys[i];
            if (nextKey == key || nextKey != null && nextKey.equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
