package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int indexKey = 0;
    private int indexValue = 0;
    private int countNull = 0;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int marker = 0;
        if (key == null) {
            countNull = countNull + 1;
        }
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (key != null && key.equals(keys[i])) {
                values [i] = value;
                marker = marker + 1;
            }
            if (countNull > 1) {
                values [i] = value;
                break;

            }
        }
        if (keys[indexKey] == null) {
            keys[indexKey] = key;
        } else if (marker < 1) {
            indexKey++;
            keys[indexKey] = key;
        }
        if (values[indexValue] == null) {
            values[indexValue] = value;
        } else if (marker < 1) {
            indexValue++;
            values[indexValue] = value;
            if (values[indexValue] != null) {
                indexKey++;
            }
        }
    }

    @Override
    public V get(K key) {
        V some = null;
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (values[i] != null && key == null && keys[i] == null) {
                some = values[i];
                break;
            } else if (keys[i] != null && key != null && key.equals(keys[i])) {
                some = values[i];
            }
        }
        return some;
    }

    @Override
    public int size() {
        int countLength = 0;
        if (countNull > 1) {
            return 1;
        } else {
            for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
                if (keys[i] != null || values[i] != null) {
                    countLength = countLength + 1;
                }
            }
        }
        return countLength;
    }
}
