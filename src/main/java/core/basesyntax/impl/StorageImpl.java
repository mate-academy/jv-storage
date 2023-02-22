package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int BOUND_OF_ARRAY = 10;
    private final K[] keysArray = (K[]) new Object[BOUND_OF_ARRAY];
    private final V[] valuesArray = (V[]) new Object[BOUND_OF_ARRAY];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keysArray[i])) {
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
