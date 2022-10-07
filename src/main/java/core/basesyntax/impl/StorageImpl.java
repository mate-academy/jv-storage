package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private ArrayList<K> keys = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index == -1) {
            keys.add(key);
            values.add(value);
            return;
        }
        values.set(index, value);
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        return (index == -1) ? null : values.get(index);
    }

    @Override
    public int size() {
        return keys.size();
    }
}
