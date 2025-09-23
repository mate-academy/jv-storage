package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final List<K> keys = new ArrayList<K>();
    private final List<V> values = new ArrayList<V>();

    @Override
    public void put(K key, V value) {
        int index = keys.indexOf(key);

        if (index == -1) {
            keys.add(key);
            values.add(value);
        } else {
            keys.set(index, key);
            values.set(index, value);
        }
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);

        if (index != -1) {
            return values.get(index);
        }

        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
