package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Map<K, V> storage;

    public StorageImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
