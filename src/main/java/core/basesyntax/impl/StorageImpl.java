package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_INDEX = 0;
    private static final int SIZE = 5;
    private Object[] keys = new Object[SIZE];
    private Object[] values = new Object[SIZE];
    private int arrayIndex = 0;

    @Override
    public void put(K key, V value) {
        if (arrayIndex == START_INDEX) {
            addToArrays(key, value, arrayIndex);
            arrayIndex++;
        } else if (arrayIndex < SIZE) {
            if (!isExist(key, value)) {
                addToArrays(key, value, arrayIndex);
                arrayIndex++;
            }
        } else {
            throw new RuntimeException("You can't add data because storage is full!");
        }
    }

    private void addToArrays(K key, V value, int index) {
        this.keys[index] = key;
        this.values[index] = value;
    }

    private boolean isExist(K key, V value) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key) {
                addToArrays(key, value, i);
                return true;
            } else if (keys[i] != null && keys[i].equals(key)) {
                addToArrays(key, value, i);
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key) {
                return (V) values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arrayIndex;
    }
}
