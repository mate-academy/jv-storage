package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private V[] arrayValue;
    private K[] arrayKey;
    private int size;

    public StorageImpl() {
        arrayValue = (V[]) new Object[MAX_SIZE];
        arrayKey = (K[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size(); i++) {
            if (key == null && arrayKey[i] == null) {
                arrayValue[i] = value;
                return;
            }
            if (key != null && key.equals(arrayKey[i])) {
                arrayValue[i] = value;
                return;
            }
        }
        arrayValue[size()] = value;
        arrayKey[size()] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (key == null && arrayKey[i] == null
                    || key != null && arrayKey[i] == key) {
                return arrayValue[i];
            }
        }
        for (int i = 0; i < size(); i++) {
            if (key != null && arrayKey[i].equals(key)) {
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
