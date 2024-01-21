package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K, V> map = new HashMap<>();

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
