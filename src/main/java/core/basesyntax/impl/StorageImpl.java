package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int DEFAULT_CAPACITY = 10;
    private int realSize = 0;
    private K[] keys = (K[]) new Object[DEFAULT_CAPACITY];
    private V[] values = (V[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        int foundKey = getIndex(key);
        if (foundKey == -1) {
            keys[realSize] = key;
            values[realSize] = value;
            realSize++;
        } else {
            values[foundKey] = value;
        }
    }

    private int getIndex(K key) {
        int foundKey = -1;
        for (int i = 0; i < realSize; i++) {
            if ((key == null && keys[i] == null) || (keys[i] != null && keys[i].equals(key))) {
                foundKey = i;
                break;
            }
        }
        return foundKey;
    }

    @Override
    public V get(K key) {
        int foundKey = getIndex(key);
        if (foundKey == -1) {
            return null;
        } else {
            return values[foundKey];
        }
    }

    @Override
    public int size() {
        return realSize;
    }
}
