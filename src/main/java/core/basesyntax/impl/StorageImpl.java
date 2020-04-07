package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int SIZE = 10;
    private Object[] arrayKey;
    private Object[] arrayValue;
    private int lastIndex;

    public StorageImpl() {
        arrayKey = new Object[SIZE];
        arrayValue = new Object[SIZE];
        lastIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        if (findKey(key) != -1) {
            arrayValue[findKey(key)] = value;
        } else {
            arrayKey[lastIndex] = key;
            arrayValue[lastIndex] = value;
            lastIndex++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lastIndex; i++) {
            if (key == arrayKey[i] || (key != null && key.equals(arrayKey[i]))) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    private int findKey(K key) {
        for (int i = 0; i < lastIndex; i++) {
            if (key == arrayKey[i] || (key != null && key.equals(arrayKey[i]))) {
                return i;
            }
        }
        return -1;
    }
}
