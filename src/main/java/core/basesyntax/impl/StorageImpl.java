package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH_STORAGE = 10;
    private K[] keyArray = (K[]) new Object[MAX_LENGTH_STORAGE];
    private V[] valueArray = (V[]) new Object[MAX_LENGTH_STORAGE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            valueArray[indexOf(key)] = value;
        } else {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }

    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            return valueArray[indexOf(key)];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyArray[i] == null || (key != null && key.equals(keyArray[i]))) {
                return i;
            }
        }
        return -1;
    }

    private boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyArray[i] == null || (key != null && key.equals(keyArray[i]))) {
                return true;
            }
        }
        return false;
    }
}
