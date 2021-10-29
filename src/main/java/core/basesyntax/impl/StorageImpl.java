package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (keys[i] == null && values[i] != null) {
                    values[i] = value;
                    return;
                }
            }
        }
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keys[i] != null) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            }
            if (keys[i] == null && values[i] == null) {
                values[i] = value;
                keys[i] = key;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (keys[i] == null && keys[i] == key && values[i] != null) {
                return (V) values[i];
            }
            if (keys[i] != null && values[i] != null) {
                if (keys[i].equals(key)) {
                    return (V) values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int countSize = 0;
        for (Object value : values) {
            if (value != null) {
                countSize += 1;
            }
        }
        return countSize;
    }
}
