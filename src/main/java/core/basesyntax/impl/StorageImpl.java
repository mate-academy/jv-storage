package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final Map<K,V> states = new HashMap<K, V>();

    @Override
    public void put(K key, V value) {

        states.put(key,value);
    }

    @Override
    public V get(K key) {
        return states.get(key);
    }

    @Override
    public int size() {

        return states.size();
    }
}
