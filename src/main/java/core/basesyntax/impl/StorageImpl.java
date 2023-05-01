package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private final K[] keysArray = (K[]) new Object[MAX_ARRAY_SIZE];
    private final V[] valuesArray = (V[]) new Object[MAX_ARRAY_SIZE];
    private int size;

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keysArray.length; i++) {
            if (keysArray[i] == null && valuesArray[i] == null) {
                size++;
                keysArray[i] = key;
                valuesArray[i] = value;
                return;
            } else if (Objects.equals(key, keysArray[i])) {
                valuesArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
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
