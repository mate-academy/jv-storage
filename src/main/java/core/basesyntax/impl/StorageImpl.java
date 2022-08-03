package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K, V> storageMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        if (storageMap.containsKey(key)) {
            storageMap.put(key, value);
        } else {
            storageMap.putIfAbsent(key, value);
        }
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
