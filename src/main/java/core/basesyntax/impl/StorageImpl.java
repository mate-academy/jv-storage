package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public StorageImpl() {
        keys = new ArrayList<>(MAX_SIZE);
        values = new ArrayList<>(MAX_SIZE);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.size(); i++) {
            if ((keys.get(i) == null && key == null)
                    || (keys.get(i) != null && keys.get(i).equals(key))) {
                values.set(i, value);
                return;
            }
        }
        if (keys.size() < MAX_SIZE) {
            keys.add(key);
            values.add(value);
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if ((keys.get(i) == null && key == null)
                    || (keys.get(i) != null && keys.get(i).equals(key))) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keys.size();
    }
}
