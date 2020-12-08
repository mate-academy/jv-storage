package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_OF_ARRAY = 10;
    private final Object[] keys = new Object[SIZE_OF_ARRAY];
    private final Object[] values = new Object[SIZE_OF_ARRAY];
    private int currentIndex = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            if (keys[i] == key) {
                values[i] = value;
            }
        }
        keys[currentIndex] = key;
        values[currentIndex] = value;
        currentIndex++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int j = 0; j < SIZE_OF_ARRAY; j++) {
                if (keys[j] == null) {
                    return (V) values[j];
                }
            }
        }
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
