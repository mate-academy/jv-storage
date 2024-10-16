package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.*;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K, V> kvMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        kvMap.put(key, value);
    }

    @Override
    public V get(K key) {
        return kvMap.get(key);
    }

    @Override
    public int size() {
        return kvMap.size();
    }

    public Map<K, V> getKvMap() {
        return kvMap;
    }

    public void setKvMap(HashMap<K, V> kvMap) {
        this.kvMap = kvMap;
    }
}
