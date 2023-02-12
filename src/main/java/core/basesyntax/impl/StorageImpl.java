package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final HashMap<K, V> storage = new HashMap<>();

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return storage.containsKey(key) ? storage.get(key) : null;
    }

    @Override
    public int size() {
        return storage.size();
    }
}
