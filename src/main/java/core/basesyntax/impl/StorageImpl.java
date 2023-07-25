package core.basesyntax.impl;


import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final List<K> keys;
    private final List<V> values;

    public StorageImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            int nullKeyIndex = keys.indexOf(null);
            if (nullKeyIndex != -1) {
                values.set(nullKeyIndex, value);
            } else {
                keys.add(null);
                values.add(value);
            }
        } else {
            int index = keys.indexOf(key);
            if (index != -1) {
                values.set(index, value);
            } else {
                if (keys.size() == MAX_SIZE) {
                    throw new IllegalStateException("Storage is full.");
                }
                keys.add(key);
                values.add(value);
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            int index = keys.indexOf(null);
            return (index != -1) ? values.get(index) : null;
        }
        int index = keys.indexOf(key);
        return (index != -1) ? values.get(index) : null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
