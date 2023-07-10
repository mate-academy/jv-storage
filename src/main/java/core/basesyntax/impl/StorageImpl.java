package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public StorageImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index >= 0) {
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        return index != -1 ? values.get(index) : null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
