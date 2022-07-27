package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final Object[] values;
    private final Object[] keys;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key && keys[i] == null
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index == -1) {
            try {
                keys[size] = key;
                values[size] = value;
                size++;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Index out of length", e);
            }
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
