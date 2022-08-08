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
        int index = getIndex(key);
        if (index == -1) {
            keys[sizeOfStorage] = key;
            values[sizeOfStorage] = value;
            sizeOfStorage++;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }

    private int getIndex(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if ((keys[i] == key || key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
