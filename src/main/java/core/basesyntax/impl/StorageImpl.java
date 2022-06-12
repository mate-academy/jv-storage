package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.HashMap;

public class StorageImpl<K, V> implements Storage<K, V> {
    private HashMap<K, V> storage = new HashMap<K, V>();

    public HashMap<K, V> getStorage() {
        return storage;
    }

    public void setStorage(HashMap<K, V> storage) {
        this.storage = storage;
    }

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return getStorage().get(key);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
