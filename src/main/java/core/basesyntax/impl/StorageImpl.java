package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private int size = 0;
    private final K[] keyArr;
    private final V[] valueArr;

    public StorageImpl() {
        keyArr = (K[]) new Object[MAX_ARRAY_SIZE];
        valueArr = (V[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size == 0) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
            return;
        }
        if (rewriteIfExist(key, value)) {
            return;
        }
        keyArr[size] = key;
        valueArr[size] = value;
        size++;
    }

    private boolean rewriteIfExist(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyArr[i] == null) {
                valueArr[i] = value;
                return true;
            }
            if (keyArr[i] != null && keyArr[i].equals(key)) {
                valueArr[i] = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && keyArr[i] == null) {
                return valueArr[i];
            }
            if (keyArr[i] != null && keyArr[i].equals(key)) {
                return valueArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
