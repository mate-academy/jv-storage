package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int countOfPairs;

    public StorageImpl() {
        keys = new Object[MAXIMUM_SIZE];
        values = new Object[MAXIMUM_SIZE];
    }

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
        for (int i = 0; i < countOfPairs; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return (V) values[i];
            }

        }
        return null;
    }

    @Override
    public int getSize() {
        return countOfPairs;
    }
}
