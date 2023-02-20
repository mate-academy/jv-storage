package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int BOUND_OF_ARRAY = 10;
    private final K[] keysArray = (K[]) new Object[BOUND_OF_ARRAY];
    private final V[] valuesArray = (V[]) new Object[BOUND_OF_ARRAY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (Arrays.asList(keysArray).contains(key)) {
            if (valuesArray[Arrays.asList(keysArray).indexOf(key)] == null) {
                size++;
            }
            valuesArray[Arrays.asList(keysArray).indexOf(key)] = value;
        } else {
            keysArray[size] = key;
            valuesArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (Arrays.asList(keysArray).contains(key)) {
            return valuesArray[Arrays.asList(keysArray).indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
