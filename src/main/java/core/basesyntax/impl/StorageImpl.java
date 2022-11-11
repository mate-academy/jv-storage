package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] arrayKey = new Object[MAX_SIZE];
    private Object[] arrayValue = new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkOnEquals(key, i)) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayKey[size] = key;
        arrayValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkOnEquals(key, i)) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkOnEquals(K key, int i) {
        return (key == null) ? (arrayKey[i] == null) : (key.equals(arrayKey[i]));
    }
}
