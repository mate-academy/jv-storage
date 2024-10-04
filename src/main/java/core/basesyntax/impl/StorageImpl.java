package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_MAX_SIZE = 10;
    private int size = 0;
    private final K[] keyArray;
    private final V[] valueArray;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keyArray = (K[]) new Object[STORAGE_MAX_SIZE];
        valueArray = (V[]) new Object[STORAGE_MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keyArray[i], key)) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < STORAGE_MAX_SIZE) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full!");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
