package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_CAPACITY];
        valuesArray = (V[]) new Object[MAX_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keysArray[i]) || key == keysArray[i]) {
                valuesArray[i] = value;
                return;
            }
        }
        keysArray[size] = key;
        valuesArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
