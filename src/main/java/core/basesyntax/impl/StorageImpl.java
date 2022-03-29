package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;

    private K[] keyData = (K[]) new Object[STORAGE_CAPACITY];
    private V[] valueData = (V[]) new Object[STORAGE_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keyData[i]) || key == keyData[i]) {
                size--;
                keyData[i] = key;
                valueData[i] = value;
            }
        }
        keyData[size] = key;
        valueData[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keyData[i]) || key == keyData[i]) {
                return (V) valueData[i];
            }
        }   return null;
    }

    @Override
    public int size() {
        return size;
    }
}

/*
@Override
    public void put(K key, V value) {
        if (!found(key)) {
            keyData[size] = key;
            valueData[size] = value;
            size++;
        }
        keyData[(int) key] = key;
        valueData[(int) key] = value;
        size++;

    }
 */
