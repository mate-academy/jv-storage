package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size = 0;

    public StorageImpl() {
        this.keys = new Object[MAX_ITEMS_NUMBER];
        this.values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K key) {
        int index = 0;
        while (index < size) {
            if (key == keys[index] || (key != null && key.equals(keys[index]))) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
