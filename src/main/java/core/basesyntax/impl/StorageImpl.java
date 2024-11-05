package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAYSIZE = 10;
    private int arrayIndex = 0;
    private Object[] keys = new Object[ARRAYSIZE];
    private Object[] values = new Object[ARRAYSIZE];

    @Override
    public void put(K key, V value) {
        if (arrayIndex < ARRAYSIZE) {
            addToArray(key, value);
        } else {
            throw new RuntimeException("Array is Full");
        }

    }

    public void addToArray(K key, V value) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        this.keys[arrayIndex] = key;
        this.values[arrayIndex] = value;
        arrayIndex++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arrayIndex; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
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
