package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10; 
    private final K[] keys;
    private final V[] values;
    private int size;
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
