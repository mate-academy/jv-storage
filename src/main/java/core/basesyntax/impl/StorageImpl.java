package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;
    private final Object[] keys = new Object[SIZE];
    private final Object[] values = new Object[SIZE];
    private int countOfPairs = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < countOfPairs; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[countOfPairs] = key;
        values[countOfPairs] = value;
        countOfPairs++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }

        }
        return (V) values[countOfPairs];
    }

    @Override
    public int size() {
        return countOfPairs;
    }
}
