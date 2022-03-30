package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private Object[] keys;
    private Object[] values;
    private int size = 0;

    public StorageImpl() {
        keys = new Object[MAX_ARRAY_SIZE];
        values = new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);
        if (index != -1) {
            values[index] = value;
        } else {
            if (size > 10) {
                System.out.println("Storage is full");
                return;
            }
            values[size] = value;
            keys[size] = key;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndexByKey(K key) { // -1 if storage haven't this key
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
