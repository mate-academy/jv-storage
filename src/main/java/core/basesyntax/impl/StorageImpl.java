package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys = new Object[MAX_ITEMS_NUMBER];
    private Object[] values = new Object[MAX_ITEMS_NUMBER];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (key == null) {
                    if (keys[i] == null) {
                        values[i] = value;
                        break;
                    } else {
                        continue;
                    }
                }
                if (key.equals(keys[i])) {
                    values[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    return (V) values[i];
                } else {
                    continue;
                }
            }
            if (key.equals(keys[i])) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
