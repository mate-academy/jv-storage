package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K,V> storageList = new HashMap<>();

    @Override
    public void put(K key, V value) {
        storageList.put(key, value);
    }

    @Override
    public V get(K key) {
        return storageList.get(key);
    }

    @Override
    public int size() {
        return storageList.size();
    }
}
