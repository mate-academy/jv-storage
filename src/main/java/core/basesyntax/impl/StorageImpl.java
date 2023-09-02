package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final List<K> keys;
    private final List<V> values;

    public StorageImpl() {
        keys = new ArrayList<>(MAX_SIZE);
        values = new ArrayList<>(MAX_SIZE);
    }

    @Override
    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index != -1) {
            values.set(index, value);
        } else if (keys.size() < MAX_SIZE) {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        return (index != -1) ? values.get(index) : null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
