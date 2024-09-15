package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private Object[] storageKeys;
    private Object[] storageValues;
    private int lengthCounter;

    public StorageImpl() {
        storageKeys = new Object[MAX_STORAGE_LENGTH];
        storageValues = new Object[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < lengthCounter; i++) {
            if (compare(storageKeys[i], key)) {
                storageValues[i] = value;
                return;
            }
        }
        storageKeys[lengthCounter] = key;
        storageValues[lengthCounter] = value;
        lengthCounter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lengthCounter; i++) {
            if (compare(storageKeys[i], key)) {
                return (V) storageValues[keyIndex];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lengthCounter;
    }

    public boolean compare(Object key1, Object key2) {
        return (key1 == key2) || (key1 != null && key1.equals(key2));
    }
}
