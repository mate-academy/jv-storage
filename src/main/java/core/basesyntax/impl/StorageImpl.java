package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LNGTH = 10;
    private static final byte NOT_FOUND_VALUE = -1;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LNGTH];
        values = (V[]) new Object[MAX_LNGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index == NOT_FOUND_VALUE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        return index != NOT_FOUND_VALUE
                ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int index = 0; index < size; index++) {
            K curKey = keys[index];
            if ((curKey != null && curKey.equals(key) || curKey == key)) {
                return index;
            }
        }
        return NOT_FOUND_VALUE;
    }
}
