package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K,V> {
    private Object[][] storage = new Object[2][1];

    @Override
    public void put(K key, V value) {
        if (key == null || key.equals(storage[0][storage[0].length - 1])) {
            storage[1][storage[1].length - 1] = value;
        } else {
            storage[0] = Arrays.copyOf(storage[0], storage[0].length + 1);
            storage[0][storage[0].length - 1] = key;
            storage[1] = Arrays.copyOf(storage[1], storage[1].length + 1);
            storage[1][storage[1].length - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storage[0].length; i++) {
            if (key == null || key.equals(storage[0][i])) {
                return (V)storage[1][i];
            }
        }
        return null;
    }
}

