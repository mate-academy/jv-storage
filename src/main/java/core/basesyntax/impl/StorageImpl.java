package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LIST_CAPACITY = 10;
    private List<K> keys = new ArrayList<>(LIST_CAPACITY);
    private List<V> values = new ArrayList<>(LIST_CAPACITY);

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        if (keys.contains(key)) {
            values.remove(keys.indexOf(key));
            values.add(keys.indexOf(key), value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        return keys.contains(key) ? values.get(keys.indexOf(key)) : null;
    }

    @Override
    public int size() {
        return (keys.size() == values.size() ? keys.size() : 0);
    }
}
