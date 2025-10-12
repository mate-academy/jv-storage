package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int maxSize = 10;

    private Object[] keys;
    private Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[maxSize];
        this.values = new Object[maxSize];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexByKey(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size < maxSize) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
