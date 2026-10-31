package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private V value;
    private K key;

    @Override
    public void put(K key, V value) {
        if (size() < 10) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V get(K key) {
        return this.value;
    }

    @Override
    public int size() {
        int i = 0;
        for (K keyElement : this.key) {
            i++;
        }
    }
}
