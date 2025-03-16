package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int indexForReplace = getExistIndex(key);
        if (indexForReplace != -1) {
            values[indexForReplace] = value;
        } else if (size <= MAX_ITEMS_NUMBER) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= size; i++) {
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

    private int getExistIndex(K keyForCheck) {
        for (int i = 0; i < size; i++) {
            if (check(keyForCheck,keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(K keyForCheck, Object value) {
        return value != null && value.equals(keyForCheck) || keyForCheck == value;
    }
}
