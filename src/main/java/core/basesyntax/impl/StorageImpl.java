package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private Object[] arrayOfKey;
    private Object[] arrayOfValue;
    private int size;

    public StorageImpl() {
        arrayOfKey = new Object[LENGTH];
        arrayOfValue = new Object[LENGTH];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        int idx = getIdxTheSameKey(key);
        arrayOfKey[idx] = key;
        arrayOfValue[idx] = value;
    }

    @Override
    public V get(K key) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (arrayOfKey[i] == key || arrayOfKey[i].equals(key)) {
                    return (V) arrayOfValue[i];
                }
            }
        }
        return null;
    }

    private int getIdxTheSameKey(K key) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (arrayOfKey[i] == key) {
                    return i;
                }
            }
        }
        return size++;
    }
}
