package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;
    private int dataSize;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        this.values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index != -1) {
            this.values[index] = value;
            return;
        }
        this.keys[dataSize] = key;
        this.values[dataSize] = value;
        this.dataSize++;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return index >= 0 ? values[index] : null;
    }

    @Override
    public int size() {
        return dataSize;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < dataSize; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
