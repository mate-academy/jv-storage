package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private Map<K, V> map;

    public StorageImpl() {
        map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        if (map.size() <= 10 || map.containsKey(key)) {
            map.put(key,value);
            return;
        }
        throw new IllegalArgumentException("Max size of the map is exceeded!");
    }

    @Override
    public V get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }
}
