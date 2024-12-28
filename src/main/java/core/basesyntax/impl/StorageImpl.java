package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_SIZE = 10;
    private List<K> keys;
    private List<V> values;

    public StorageImpl() {
        this.keys = new ArrayList<>(MAX_SIZE);
        this.values = new ArrayList<>(MAX_SIZE);
    }

    @Override
    public void put(K key, V value) {
        if (size() >= MAX_SIZE) {
            throw new IllegalStateException("Storage is full, cannot add more items.");
        }

        for (int i = 0; i < size(); i++) {
            if ((keys.get(i) == null && key == null)
                    || (keys.get(i) != null && keys.get(i).equals(key))) {
                values.set(i, value);
                return;
            }
        }

        keys.add(key);
        values.add(value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
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
