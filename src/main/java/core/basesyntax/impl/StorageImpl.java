package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int count;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
        count = 0;
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexOfKey(key);
        if (index != -1) {
            values[index] = value;
        } else {
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexOfKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
