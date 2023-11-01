package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY = 10;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int countIndex = 0;

    public StorageImpl(int size) {
        keyStorage = new Object[size];
        valueStorage = new Object[size];
    }

    public StorageImpl() {
        this(SIZE_ARRAY);
    }

    @Override
    public void put(K key, V value) {
        int indexKey = getIndexAndCheckExistKey(key);
        if (indexKey >= 0) {
            valueStorage[indexKey] = value;
        } else {
            keyStorage[countIndex] = key;
            valueStorage[countIndex++] = value;
        }
    }

    @Override
    public V get(K key) {
        int indexKey = getIndexAndCheckExistKey(key);
        if (indexKey >= 0) {
            return (V) valueStorage[indexKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return countIndex;
    }

    private int getIndexAndCheckExistKey(K key) {
        if (key == null) {
            for (int i = 0; i < countIndex; i++) {
                if (keyStorage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < countIndex; i++) {
                if (key.equals(keyStorage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}


