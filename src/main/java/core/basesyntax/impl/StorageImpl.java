package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_VALUE = 10;
    private static final int NON_EXISTENT_INDEX = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_VALUE];
        values = (V[]) new Object[MAX_VALUE];
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == NON_EXISTENT_INDEX) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index != NON_EXISTENT_INDEX) {
            return values[index];
        }
        return null;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null && keys[i].equals(key) || key == keys[i]) {
                return i;
            }
        }
        return NON_EXISTENT_INDEX;
    }

    @Override
    public int size() {
        return size;
    }
}
