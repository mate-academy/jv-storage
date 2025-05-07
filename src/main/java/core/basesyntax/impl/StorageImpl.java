package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private final K[] keys;
    private final V[] values;
    private int sizeOfStorage;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        if (getIndex(key) == -1) {
            keys[sizeOfStorage] = key;
            values[sizeOfStorage] = value;
            sizeOfStorage++;
        } else {
            values[getIndex(key)] = value;
        }
    }

    @Override
    public V get(K key) {
        if (getIndex(key) == -1) {
            return null;
        }
        return values[getIndex(key)];
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }

    private int getIndex(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
