package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int size;
    private K[] keys = (K[]) new Object[MAX_LENGTH];
    private V[] values = (V[]) new Object[MAX_LENGTH];

    private Integer getIndex(K key) {
        Integer result = null;
        for (int index = 0; index < size; index++) {
            if (keys[index] == key && keys[index] == null
                    || (keys[index] != null && keys[index].equals(key))) {
                result = index;
            }
        }
        return result;
    }

    @Override
    public void put(K key, V value) {
        Integer index = getIndex(key);
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
        Integer index = getIndex(key);
        return index != null ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }
}
