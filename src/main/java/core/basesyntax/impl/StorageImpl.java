package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_STORAGE_ELEMENTS = 10;
    private Object[] keys;
    private Object[] values;
    private int size;
    private int getKeyIndex;

    public StorageImpl() {
        keys = new Object[MAXIMUM_STORAGE_ELEMENTS];
        values = new Object[MAXIMUM_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[getKeyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                getKeyIndex = i;
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
