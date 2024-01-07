package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;

    public StorageImpl() {

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
        return -1;
    }
}
