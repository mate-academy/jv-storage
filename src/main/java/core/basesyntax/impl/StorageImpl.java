package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int currentSize;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (currentSize < 10) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        } else {
            throw new RuntimeException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null || keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
