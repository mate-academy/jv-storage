package core.basesyntax.impl;

import java.util.Objects;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final int MAX = 10;

    Object[] keys = new Object[MAX];
    Object[] values = new Object[MAX];
    int size = 0;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {

            if (Objects.equals(keys[i], key)) {

                values[i] = value;
                return;
            }
        }

        keys[size] = key;
        values[size] = value;

        size++;

    }

    @Override
    public V get(K key) {

        for (int i = 0; i < size; i++) {

            if (Objects.equals(keys[i], key)) {

                return (V) values[i];
            }

        }
        return null;

    }

    @Override
    public int size() {
        return size;
    }
}
