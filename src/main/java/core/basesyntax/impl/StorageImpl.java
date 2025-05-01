package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final ArrayList<K> keys;
    private final ArrayList<V> values;

    public StorageImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        int index = searchByKey(key);
        if (index >= 0) {
            values.set(index, value);
        } else {
            if (keys.size() >= MAX_CAPACITY) {
                throw new IllegalStateException("Storage is full! Maximum capacity is " + MAX_CAPACITY);
            }
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        int index = searchByKey(key);
        return index >= 0 ? values.get(index) : null;
    }

    @Override
    public int size() {
        return keys.size();
    }

    private int searchByKey(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key == keys.get(i) || (key != null && key.equals(keys.get(i)))) {
                return i;
            }
        }
        return -1;
    }
}
