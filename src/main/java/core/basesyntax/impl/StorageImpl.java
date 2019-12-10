package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.HashMap;
import java.util.Map;
//import java.util.Set; for (MapEntry entry : storage.entrySet())

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private Map<K, V> storage = new HashMap<K, V>();

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }
}

