package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] arrayKey;
    private V[] arrayValue;
    private int size;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_SIZE];
        arrayValue = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == arrayKey[i] || arrayKey[i] != null && arrayKey[i].equals(key)) {
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
            if (key == arrayKey[i] || arrayKey[i] != null && arrayKey[i].equals(key)) {
                return arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
