package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] keys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private V[] values = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        if (size == MAX_NUMBER_OF_ELEMENTS) {
            throw new RuntimeException("Storage is full");
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
