package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_VALUE = 10;
    private Object[] keys;
    private Object[] values;
    private int countForSize;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_VALUE];
        values = new Object[MAX_ITEMS_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < countForSize; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                countForSize = i + 1;
                return;
            }
        }
        keys[countForSize] = key;
        values[countForSize] = value;
        countForSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_VALUE; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return countForSize;
    }
}
