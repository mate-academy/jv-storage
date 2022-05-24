package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final K[] keyBox = (K[]) new Object[MAX_SIZE];
    private final V[] valueBox = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        int indexKey = getIndexKey(key);
        if (indexKey != -1) {
            valueBox[indexKey] = value;
            return;
        }
        keyBox[size] = key;
        valueBox[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (getIndexKey(key) >= 0) {
            return valueBox[getIndexKey(key)];
        }
        return null;
    }

    public int getIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keyBox[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
