package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_VALUE = 10;
    private final List<K> keys;
    private final List<V> values;

    public StorageImpl() {
        keys = new ArrayList<>(MAX_ARRAY_VALUE);
        values = new ArrayList<>(MAX_ARRAY_VALUE);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == null ? key == null : keys.get(i).equals(key)) {
                values.set(i, value);
                return;
            }
        }
        keys.add(key);
        values.add(value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == null ? key == null : keys.get(i).equals(key)) {
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
