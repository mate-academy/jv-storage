package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Map<K, V> data = new HashMap<>();

    @Override
    public void put(K key, V value) {
        data.put(key, value);
    }

    @Override
    public V get(K key) {
        return data.get(key);
    }

    @Override
    public int size() {
        return data.size();
    }
}
