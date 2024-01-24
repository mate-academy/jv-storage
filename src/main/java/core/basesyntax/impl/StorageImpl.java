package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndexOfKey(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int getIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
