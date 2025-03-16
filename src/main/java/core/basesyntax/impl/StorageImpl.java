package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] keyStorage;
    private final Object[] valueStorage;
    private int size;

    public StorageImpl(int size) {
        keyStorage = new Object[size];
        valueStorage = new Object[size];

    }

    public StorageImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        int indexKey = getKeyIndex(key);
        if (indexKey >= 0) {
            valueStorage[indexKey] = value;
        } else {
            keyStorage[size] = key;
            valueStorage[size++] = value;

        }
    }

    @Override
    public V get(K key) {
        int indexKey = getKeyIndex(key);
        if (indexKey >= 0) {
            return (V) valueStorage[indexKey];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keyStorage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keyStorage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}


