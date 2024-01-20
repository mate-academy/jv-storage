package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE_STORAGE = 10;
    private int sizeStorage;
    private K[] keys = (K[]) new Object[MAX_SIZE_STORAGE];
    private V[] values = (V[]) new Object[MAX_SIZE_STORAGE];

    @Override
    public void put(K key, V value) {
        int indexKey = getIndexKey(key);
        if (indexKey != -1) {
            values[indexKey] = value;
            return;
        }
        keys[sizeStorage] = key;
        values[sizeStorage] = value;
        sizeStorage++;
    }

    @Override
    public V get(K key) {
        int indexKey = getIndexKey(key);
        if (indexKey != -1) {
            return values[indexKey];
        }
        return null;
    }

    private int getIndexKey(K key) {
        for (int i = 0; i < sizeStorage; i++) {
            if (keys[i] == key || keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.sizeStorage;
    }
}
