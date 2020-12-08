package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_LENGTH = 10;
    V[] valuesArray = (V[]) new Object[MAX_ARRAY_LENGTH];
    V nullKeyElement;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullKeyElement = value;
        } else {
            valuesArray[Math.abs(key.hashCode() % MAX_ARRAY_LENGTH)] = value;
        }
    }

    @Override
    public V get(K key) {
        return (key != null) ? valuesArray[Math.abs(key.hashCode() % MAX_ARRAY_LENGTH)]
                : nullKeyElement;
    }
}
