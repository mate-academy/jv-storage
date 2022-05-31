package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_STORAGE_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        keys = new Object[MAXIMUM_STORAGE_ELEMENTS];
        values = new Object[MAXIMUM_STORAGE_ELEMENTS];
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[getKeyIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getKeyIndex(key) != -1) {
            return (V) values[getKeyIndex(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
