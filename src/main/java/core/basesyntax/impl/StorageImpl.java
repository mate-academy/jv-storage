package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int START_ITEMS_NUMBER = -1;
    private final Object[] keys;
    private final Object[] values;
    private int occupiedValues;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        occupiedValues = START_ITEMS_NUMBER;
    }

    @Override
    public void put(K key, V value) {
        if (checkKey(key,value)) {
            return;
        } else if (occupiedValues < MAX_ITEMS_NUMBER) {
            occupiedValues++;
            keys[occupiedValues] = key;
            values[occupiedValues] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= occupiedValues; i++) {
            if (keys[i] != null && keys[i].equals(key) || key == keys[i]) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return occupiedValues - START_ITEMS_NUMBER;
    }

    private boolean checkKey(K keyForCheck, V value) {
        for (int i = 0; i <= occupiedValues; i++) {
            if (keys[i] != null && keys[i].equals(keyForCheck) || keyForCheck == keys[i]) {
                values[i] = value;
                return true;
            }
        }
        return false;
    }
}
