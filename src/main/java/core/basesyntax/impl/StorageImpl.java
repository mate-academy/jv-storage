package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;

    private K[] keyData;
    private V[] valueData;
    private int size;

    public StorageImpl() {
        keyData = (K[]) new Object[STORAGE_CAPACITY];
        valueData = (V[]) new Object[STORAGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isLegit(i, key)) {
                keyData[i] = key;
                valueData[i] = value;
                return;
            }
        }
        keyData[size] = key;
        valueData[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (isLegit(i, key)) {
                return valueData[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isLegit(int index, K key) {
        return key != null && key.equals(keyData[index]) || key == keyData[index];
    }
}
