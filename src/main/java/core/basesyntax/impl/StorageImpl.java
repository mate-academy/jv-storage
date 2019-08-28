package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K,V> {
    private int capacity = 16;
    private int fill = 0;
    private Object[] keys = new Object[capacity];
    private Object[] values = new Object[capacity];

    @Override
    public void put(K key, V value) {
        if (fill == capacity - 1) {
            Object[] newKeys = new Object[capacity * 2];
            Object[] newValues = new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }
            keys = newKeys;
            values = newValues;
        }

        for (int i = 0; i < fill; i++) {
            if (keys[i] == key) {
                values[i] = value;
                break;
            }
        }

        keys[fill] = key;
        values[fill] = value;
        fill++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < fill; i++) {
            if (keys[i] == key) {
                return (V) values[i];
            }
        }
        return null;
    }
}

