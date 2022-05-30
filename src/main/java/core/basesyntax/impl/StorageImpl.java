package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private Object[] keys = new Object[ARRAY_LENGTH];
    private Object[] values = new Object[ARRAY_LENGTH];

    @Override
    public void put(K key, V value) {
        new PutValue<>(key, value, keys, values);
    }

    @Override
    public V get(K key) {
        return (V) new GetValue<>(key, this.keys, this.values).valueOf();
    }

    @Override
    public int size() {
        return new GetSize(this.values).size();
    }
}
