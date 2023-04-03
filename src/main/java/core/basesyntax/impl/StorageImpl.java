package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int currentSize;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        sizeCheck();
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(keys[i], key)) {
                value = (V) values[i];
            }
        }
        return value;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) o;
        return currentSize == storage.currentSize
                && Arrays.equals(keys, storage.keys)
                && Arrays.equals(values, storage.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentSize);
        result = 31 * result + Arrays.hashCode(keys);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    private void sizeCheck() {
        if (currentSize <= MAX_SIZE) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Error. Storage is full.");
    }
}
