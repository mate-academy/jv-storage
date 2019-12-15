package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int size = 0;
    private static String[][] storage = new String[10][2];
    private static final int INDEX_OF_KEY = 0;
    private static final int INDEX_OF_VALUE = 1;

    @Override
    public void put(K key, V value) {

        if (key == null && value == null) {
            storage[size][INDEX_OF_KEY] = null;
            storage[size][INDEX_OF_VALUE] = null;
        } else if (key == null ^ value == null) {
            storage[size][INDEX_OF_KEY] = key == null ? null : key.toString();
            storage[size][INDEX_OF_VALUE] = value == null ? null : value.toString();
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i][INDEX_OF_KEY] == key
                        || Objects.equals(storage[i][INDEX_OF_KEY], key.toString())) {
                    storage[i][INDEX_OF_VALUE] = value.toString();
                }
            }
            storage[size][INDEX_OF_KEY] = key.toString();
            storage[size][INDEX_OF_VALUE] = value.toString();
        }
        size++;
    }

    @Override
    public V get(K key) {
        for (String[] v : storage) {
            if (key == null) {
                if (v[INDEX_OF_KEY] == null) {
                    return (V) v[INDEX_OF_VALUE];
                }
            } else {
                if (v[INDEX_OF_KEY] == null) {
                    continue;
                } else if (v[INDEX_OF_KEY].equals(key.toString())) {
                    return (V) v[INDEX_OF_VALUE];
                }
            }
        }
        return null;
    }
}
