package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    @SuppressWarnings("unchecked")
    private K[] keyArr = (K[]) new Object[MAX_CAPACITY];
    @SuppressWarnings("unchecked")
    private V[] valArr = (V[]) new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keyArr[i] || (key != null && key.equals(keyArr[i]))) {
                valArr[i] = value;
                return;
            }
        }
        if (size < MAX_CAPACITY) {
            keyArr[size] = key;
            valArr[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keyArr[i] || (key != null && key.equals(keyArr[i]))) {
                return valArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
