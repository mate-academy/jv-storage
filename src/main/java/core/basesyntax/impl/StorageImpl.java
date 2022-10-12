package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size;
    private final Object[] valuesList;
    private final Object[] keysList;

    public StorageImpl() {
        size = 0;
        valuesList = new Object[ARRAY_SIZE];
        keysList = new Object[ARRAY_SIZE];
    }

    private Integer indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keysList[i] == key || keysList[i] != null && keysList[i].equals(key)) {
                return i;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (indexOfKey(key) != null) {
            valuesList[indexOfKey(key)] = value;
        } else {
            keysList[size] = key;
            valuesList[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return indexOfKey(key) != null ? (V) valuesList[indexOfKey(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }
}
