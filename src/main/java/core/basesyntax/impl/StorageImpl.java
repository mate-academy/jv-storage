package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INDEX_KEY = 0;
    private static final int MAX_SIZE = 10;
    private final Object[] keys;
    private final Object[] values;
    private int indexStorage = 0;

    public StorageImpl() {
        this.keys = new Object[MAX_SIZE];
        this.values = new Object[MAX_SIZE];
    }

    public void put(K key, V value) {
        int indexKey = indexOf(key);
        if (indexKey == -1) {
            keys[indexStorage] = key;
            values[indexStorage] = value;
            indexStorage++;
            if (indexStorage == 10) {
                indexStorage = 0;
            }
        } else {
            values[indexKey] = value;
            if (indexKey == indexStorage) {
                indexStorage++;
            }
        }
    }

    @Override
    public V get(K key) {
        int indexKey = indexOf(key);
        if (indexKey == -1) {
            return null;
        }
        return (V) values[indexOf(key)];
    }

    @Override
    public int size() {
        return indexStorage;
    }

    private int indexOf(K key) {
        for (int i = 0; i < keys.length; i++) {
            boolean keysAreEqual = key == null ? key == keys[i]
                    : key.equals(keys[i]);
            if (keysAreEqual) {
                return i;
            }
        }
        return -1;
    }
}

