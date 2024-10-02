package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_ELEMENTS = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_ELEMENTS];
        values = (V[]) new Object[MAX_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int ifItWasFound = 0;

        for (int i = 0; i < size(); i++) {
            ifItWasFound = 0;
            if (key != null && keys[i].equals(key)) {
                values[i] = value;
                ifItWasFound++;
            } else if (key == null && key == keys[i]) {
                values[i] = value;
            }
        }
        if (ifItWasFound == 0) {
            keys[size()] = key;
            values[size()] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            } else if (keys == null) {
                if (keys[i] == key) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int sizeKeys = 0;
        int sizeValue = 0;
        for (K currentKey : keys) {
            if (currentKey != null) {
                sizeKeys++;
            }
        }

        for (V currentKey : values) {
            if (currentKey != null) {
                sizeValue++;
            }
        }

        return sizeKeys >= sizeValue ? sizeKeys : sizeValue;
    }
}
