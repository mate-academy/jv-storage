package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_ELEMENTS_NUMBER];
        this.values = new Object[MAX_ELEMENTS_NUMBER];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = comparator(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
        } else {
            if (size < MAX_ELEMENTS_NUMBER) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = comparator(key);
        if (keyIndex != -1) {
            return (V) values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int comparator(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
