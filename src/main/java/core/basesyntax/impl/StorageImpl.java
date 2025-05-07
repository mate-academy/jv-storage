package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        size = 0;
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        V havingValue = this.get(key);
        if (havingValue == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int idx = 0; idx < MAX_ITEMS_NUMBER; idx++) {
            if (key == null && keys[idx] == null
                    || key != null && key.equals(keys[idx])) {
                return idx;
            }
        }
        return -1;
    }
}
