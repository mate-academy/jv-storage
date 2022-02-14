package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private V[] valueV = (V[]) new Object[MAX_ITEMS_NUMBER];
    private K[] keyK = (K[]) new Object[MAX_ITEMS_NUMBER];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keyK[i] == key || keyK[i] != null && keyK[i].equals(key)) {
                valueV[i] = value;
                return;
            }
        }
        valueV[size] = value;
        keyK[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyK[i] == key || keyK[i] != null && keyK[i].equals(key)) {
                return valueV[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
