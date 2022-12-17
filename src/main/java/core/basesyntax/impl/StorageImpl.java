package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K, V> kv = new HashMap();

    @Override
    public void put(K key, V value) {
        kv.put(key, value);
    }

    @Override
    public V get(K key) {
        return kv.get(key);
    }

    @Override
    public int size() {
        return kv.size();
    }
}
