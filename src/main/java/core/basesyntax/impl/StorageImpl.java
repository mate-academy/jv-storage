package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_ITEMS_NUMBER];
        values = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        keys = new Object[]{key};
        values = new Object[]{value};
    }

    @Override
    public V get(K key) {
        return (V) values[Arrays.asList(keys).indexOf(key)];
    }

    @Override
    public int size() {
        return keys.length;
    }
}
