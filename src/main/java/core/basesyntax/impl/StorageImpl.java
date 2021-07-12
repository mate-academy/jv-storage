package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Object[] keysArr;
    private Object[] valuesArr;
    private int size;

    public StorageImpl() {
        keysArr = new Object[MAX_LENGTH];
        valuesArr = new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keysArr[i] || key != null && key.equals(keysArr[i])) {
                valuesArr[i] = value;
                return;
            }
        }
        keysArr[size] = key;
        valuesArr[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keysArr[i] || key != null && key.equals(keysArr[i])) {
                return (V) valuesArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
