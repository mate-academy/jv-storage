package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private static final int NULL_PLACEHOLDER = 99;
    private Object[] values;
    private Object[] keys;
    private int size;

    public StorageImpl() {
        values = new Object[MAX_STORAGE];
        keys = new Object[MAX_STORAGE];

    }

    @Override
    public void put(K key, V value) {
        if (key == null && indexOf(key) == -1) {
            keys[size] = NULL_PLACEHOLDER;
            values[size] = value;
            size++;
            return;
        }

        if (indexOf(key) != -1) {
            values[indexOf(key)] = value;
            return;
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (indexOf(key) != -1) {
            return (V) values[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keys[i].equals(NULL_PLACEHOLDER)
                    || key != null && key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
