package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public V get(K key) {
        return value;
    }

    @Override
    public int size() {
        return (Integer) key;
    }
}
