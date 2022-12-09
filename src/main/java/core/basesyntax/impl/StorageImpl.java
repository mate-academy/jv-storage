package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int maxSize = 10;
    private final K[] keys = ((K[]) new Objects[maxSize]);
    private final V[] values = ((V[]) new Objects[maxSize]);
    private int arraySize;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }

        keys[arraySize] = key;
        values[arraySize] = value;
        arraySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }
}
