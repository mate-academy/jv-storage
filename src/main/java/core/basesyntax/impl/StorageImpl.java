package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.security.Key;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    ArrayList<K> keys = new ArrayList<>();
    ArrayList<V> values = new ArrayList<>();
    private int count = 0;
    @Override
    public void put(K key, V value) {
        if (key == null) {
            values.add(count,value);
        }
        keys.add(count, key);
        values.add(count,value);
        count++;


    }

    @Override
    public V get(K key) {
        try {
            return values.get(keys.indexOf(key));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    @Override
    public int size() {
        return values.size();
    }
}
