package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_VALUE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_STORAGE_VALUE];
        values = (V[]) new Object[MAX_STORAGE_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getIndex(key);
        if (keyIndex == -1) {
            values[size] = value;
            keys[size] = key;
            size++;
        } else {
            this.values[keyIndex] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getIndex(key);
        if (keyIndex != -1) {
            return values[keyIndex];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
