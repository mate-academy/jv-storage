package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Object[] keysArr;
    private Object[] valuesArr;
    private int capacity;

    public StorageImpl() {
        keysArr = new Object[MAX_LENGTH];
        valuesArr = new Object[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        keysArr[capacity] = key;
        valuesArr[capacity] = value;
        capacity++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < capacity; i++) {
            if (key == null && keysArr[i] == null && capacity < 3
                    || keysArr[i] != null && keysArr[i].equals(keysArr[i + 1])) {
                capacity = 1;
                return (V) valuesArr[i + 1];
            }

            if (keysArr[i] != null && key != null && key.equals(keysArr[i]) || keysArr[i] == key) {
                return (V) valuesArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return capacity;
    }
}
