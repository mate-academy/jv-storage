package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int START_SIZE = 0;
    private K key;
    private V value;
    private ArrayList<K> keys;
    private ArrayList<V> values;
    private int size;

    {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        size = START_SIZE;
    }

    @Override
    public void put(K key, V value) {
        if (keys.contains(key)) {
            int keyIndex = keys.indexOf(key);
            values.remove(keyIndex);
            values.add(keyIndex, value);
        } else {
            keys.add(key);
            values.add(value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        if (keys.contains(key)) {
            return values.get(keys.indexOf(key));
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
