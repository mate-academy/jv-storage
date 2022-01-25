package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final K[] keys;
    private final V[] values;
    private int elementsAmount;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE_OF_ARRAY];
        values = (V[]) new Object[SIZE_OF_ARRAY];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[elementsAmount] = key;
            values[elementsAmount] = value;
            elementsAmount++;
        } else {
            values[elementsAmount - 1] = value;

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementsAmount; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
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
