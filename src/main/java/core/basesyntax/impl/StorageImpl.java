package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private final K[] keysArray;
    private final V[] valueArray;
    private int size;

    public StorageImpl() {
        keysArray = (K[]) new Object[MAX_VALUE];
        valueArray = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        keysArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == key || key != null && key.equals(keysArray[i])) {
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
