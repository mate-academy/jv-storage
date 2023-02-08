package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VALUE = 10;
    private int size;
    private Object[] keys = new Object[MAX_STORAGE_VALUE];
    private Object[] values = new Object[MAX_STORAGE_VALUE];

    @Override
    public void put(K key, V value) {
        if (size < MAX_STORAGE_VALUE) {
            if (contains(keys, key)) {
                values[indexOf(keys, key)] = value;
                keys[indexOf(keys, key)] = key;
                return;
            }
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (!contains(keys, key)) {
            return null;
        }
        return (V) values[indexOf(keys, key)];
    }

    @Override
    public int size() {
        return size;
    }

    private boolean contains(Object[] array, Object key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], key)) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(Object[] array, Object key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
