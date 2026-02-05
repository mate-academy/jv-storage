package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final List<K> keys;
    private final List<V> values;
    private int size;

    public StorageImpl() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (index != -1) {
            values.set(index, value);
        } else if (size < MAX_SIZE) {
            keys.add(key);
            values.add(value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return index != -1 ? values.get(index) : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys.get(i) == null && key == null) {
                return i;
            }
            if (keys.get(i) != null && keys.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
