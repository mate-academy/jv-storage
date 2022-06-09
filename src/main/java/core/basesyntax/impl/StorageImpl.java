package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K key;
    private V value;
    private K[] keys = (K[]) new Object[MAX_LENGTH];
    private V[] values = (V[]) new Object[MAX_LENGTH];

    private Integer searchedKey(K key) {
        Integer result = null;
        for (int index = 0; index < size; index++) {
            if (keys[index] == null || key == null) {
                if (keys[index] == key) {
                    result = index;
                }
            } else if (keys[index].equals(key)) {
                result = index;
            }
        }
        return result;
    }

    @Override
    public void put(K key, V value) {
        Integer index = searchedKey(key);
        if (index != null) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = searchedKey(key);
        if (index != null) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
