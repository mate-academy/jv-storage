package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int START_ITEMS_NUMBER = -1;
    private static final int START_SIZE_NUMBER = 0;
    private final Object[] keys;
    private final Object[] values;
    private int occupiedValues;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
        occupiedValues = START_ITEMS_NUMBER;
        size = START_SIZE_NUMBER;
    }

    @Override
    public void put(K key, V value) {
        if (checkKey(key, value)) {
            return;
        } else if (occupiedValues < MAX_ITEMS_NUMBER) {
            occupiedValues++;
            size++;
            keys[occupiedValues] = key;
            values[occupiedValues] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= occupiedValues; i++) {
            if (check(key,keys[i])) {
                return (V)values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkKey(K keyForCheck, V value) {
        for (int i = 0; i <= occupiedValues; i++) {
            if (check(keyForCheck,keys[i])) {
                values[i] = value;
                return true;
            }
        }
        return false;
    }

    private boolean check(K keyForCheck, Object value) {
        return value != null && value.equals(keyForCheck) || keyForCheck == value;
    }
}
