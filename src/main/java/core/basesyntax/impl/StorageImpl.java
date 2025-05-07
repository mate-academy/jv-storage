package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private K[] arrayKey;
    private V[] arrayValue;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_SIZE];
        arrayValue = (V[]) new Object[MAX_SIZE];
    }

    private int findValue(K key) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int i = findValue(key);
        if (i != -1) {
            if (key == null && arrayKey[i] == null && arrayValue[i] == null) {
                size++;
            }
            arrayValue[i] = value;
            return;
        }
        arrayKey[size] = key;
        arrayValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int i = findValue(key);
        if (i != -1) {
            return arrayValue[i];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
