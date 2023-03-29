package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.LinkedHashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final Map<K,V> map = new LinkedHashMap<>();
    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }
}
