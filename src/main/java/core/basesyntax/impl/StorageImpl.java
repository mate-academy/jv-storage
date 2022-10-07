package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size = 0;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        Integer index = foundIndex(key);

        if (index != null) {
            values[index] = value;
        } else if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        Integer index = foundIndex(key);
        return index != null ? (V) values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private Integer foundIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || (keys[i] != null
                    && keys[i].equals(key))) {
                return i;
            }
        }

        return null;
    }
}
