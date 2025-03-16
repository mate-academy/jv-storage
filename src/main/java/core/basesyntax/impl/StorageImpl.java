package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final int maxSize = 10;

    public StorageImpl(K[] keys, V[] values) {
        this.keys = new String[maxSize];
        this.values = new String[maxSize];
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



