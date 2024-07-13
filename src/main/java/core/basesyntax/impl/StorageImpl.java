package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private int size = 0;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[ARRAY_SIZE];
        valueArray = (V[]) new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (checkKey(key, value)) {
            return;
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (key == keyArray[i]) {
                    return valueArray[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keyArray[i])) {
                    return valueArray[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean checkKey(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (key == keyArray[i]) {
                    valueArray[i] = value;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keyArray[i])) {
                    valueArray[i] = value;
                    return true;
                }
            }
        }
        return false;
    }
}
