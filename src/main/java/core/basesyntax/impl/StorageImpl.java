package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_BOUND = 10;
    private K[] storageKeys;
    private V[] storageValues;

    public StorageImpl() {
        storageKeys = (K[]) new Object[ARRAY_BOUND];
        storageValues = (V[]) new Object[ARRAY_BOUND];
    }

    @Override
    public void put(K key, V value) {
        if (indexOf(key) >= 0) {
            storageKeys[indexOf(key)] = key;
            storageValues[indexOf(key)] = value;
        } else {
            storageKeys[size()] = key;
            storageValues[size()] = value;
        }
    }

    @Override
    public V get(K key) {
        return indexOf(key) < 0 ? null : storageValues[indexOf(key)];
    }

    private int indexOf(K key) {
        for (int i = 0; i < storageKeys.length; i++) {
            if (key == storageKeys[i] || (storageKeys[i] != null
                    && storageKeys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        int i = 0;
        for (; i < storageValues.length; i++) {
            if (storageValues[i] == null) {
                break;
            }
        }
        return i;
    }
}
