package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_CAPACITY = 10;
    private int putCounter;
    private Object[] keyData;
    private Object[] valueData;

    public StorageImpl() {
        valueData = new Object[STORAGE_CAPACITY];
        keyData = new Object[STORAGE_CAPACITY];
        putCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < putCounter; i++) {
            if (key == keyData[i]
                    || (key != null
                    && (key == keyData[i] || key.equals(keyData[i])))) {
                valueData[i] = value;
                return;
            }
        }
        keyData[putCounter] = key;
        valueData[putCounter] = value;
        putCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (key == keyData[i]
                    || (key != null
                    && (key == keyData[i] || key.equals(keyData[i])))) {
                return (V) valueData[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return putCounter;
    }
}
