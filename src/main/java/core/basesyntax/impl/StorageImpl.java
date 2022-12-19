package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private final Object[] arrayOfKey = new Object[MAX_LENGTH];
    private final Object[] arrayOfValue = new Object[MAX_LENGTH];
    private int size;

    @Override
    public void put(K key, V value) {
        if (!checkedEquals(key, value)) {
            arrayOfKey[size] = key;
            arrayOfValue[size] = value;
            size++;
        } else {
            checkedEquals(key, value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (arrayOfKey[i] == key || (arrayOfKey[i] != null && arrayOfKey[i].equals(key))) {
                return (V) arrayOfValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkedEquals(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (arrayOfKey[i] == null && key == null) {
                change(i, key, value);
                return true;
            }
            if (arrayOfKey[i] == null) {
                continue;
            }
            if (arrayOfKey[i].equals(key)) {
                change(i, key, value);
                return true;
            }
        }
        return false;
    }

    private void change(int i, K key, V value) {
        arrayOfKey[i] = key;
        arrayOfValue[i] = value;
    }
}
