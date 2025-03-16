package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final Object[] keyBox;
    private final Object[] valueBox;
    private int size = 0;

    public StorageImpl() {
        keyBox = new Object[MAX_SIZE];
        valueBox = new Object[MAX_SIZE];
    }

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
            return (V) valueBox[getIndexKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((key != null && key.equals(keyBox[i])) || key == keyBox[i]) {
                return i;
            }
        }
        return -1;
    }
}

