package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final int MAX_ELEMENTS = 10;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS];
        values = (V[]) new Object[MAX_ELEMENTS];

    }

    @Override
    public void put(K key, V value) {
        int keyIndex = findExistingKeyIndex(key);
        if (keyIndex != -1) {
            values[keyIndex] = value;
        } else {
            for (int i = 0; i < MAX_ELEMENTS; i++) {
                if (keys[i] == null && values[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }
        }
    }
    
    private int findExistingKeyIndex(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                return i;
            } else if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int keyIndex = findExistingKeyIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        int elementsCount = 0;
        for (V value : values) {
            if (value != null) {
                elementsCount += 1;
            }
        }
        return elementsCount;
    }
}
