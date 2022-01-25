package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final K[] keys = (K[]) new Object[SIZE_OF_ARRAY];
    private final V[] values = (V[]) new Object[SIZE_OF_ARRAY];
    private int elementsAmount;
    private int valuesCount;

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[elementsAmount] = key;
            values[elementsAmount] = value;
            elementsAmount++;
        } else {
            values[valuesCount] = value;

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsAmount; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                valuesCount = i;
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementsAmount;
    }
}
