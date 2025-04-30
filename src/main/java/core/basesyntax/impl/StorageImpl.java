package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Map<K,V> map = new HashMap<>();
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            map.put(key,value);
            return;
        }
        map.put(key,value);
        size++;
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public int size() {
        return size;
    }
}
