package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int numbersSize;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[numbersSize] = key;
            values[numbersSize] = value;
            numbersSize++;
        } else {
            values[numbersSize - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < numbersSize; i++) {
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return numbersSize;
    }
}
