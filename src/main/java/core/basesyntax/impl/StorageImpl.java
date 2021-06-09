package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LIST_LIMIT = 10;
    private ArrayList<V> storage;
    private ArrayList<K> keys;
    private int size = 0;

    public StorageImpl() {
        storage = new ArrayList<>(LIST_LIMIT);
        keys = new ArrayList<>(LIST_LIMIT);
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (storage.size() == LIST_LIMIT) {
            throw new StorageIsFullException("Storage is full!");
        }

        if (keys.indexOf(key) >= 0) {
            storage.set(keys.indexOf(key), value);
            return;
        }
        storage.add(value);
        keys.add(key);
        size++;
    }

    @Override
    public V get(K key) {
        for (int t = 0; t < keys.size(); t++) {
            if (key == null) {
                return storage.get(keys.indexOf(null));
            }
            if (key.equals(keys.get(t))) {
                return storage.get(t);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
