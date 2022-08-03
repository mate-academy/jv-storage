package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private final Object[] keys;
    private final Object[] values;

    public StorageImpl() {
        keys = new Object[SIZE];
        values = new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {

        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
