package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Map<K, V> storageMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        storageMap.put(key, value);
    }

    @Override
    public V get(K key) {
        return storageMap.get(key);
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
