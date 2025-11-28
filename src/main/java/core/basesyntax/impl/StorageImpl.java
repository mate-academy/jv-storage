package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final CustomStorage<K, V> customStorage;

    public StorageImpl() {
        this.customStorage = new CustomStorage<>();
    }

    @Override
    public void put(K key, V value) {
        customStorage.put(key, value);
    }

    @Override
    public V get(K key) {
        return customStorage.get(key);
    }

    @Override
    public int size() {
        return customStorage.size();
    }
}
