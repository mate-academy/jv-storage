package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int usedSpace;

    public StorageImpl() {
        keys = (K[])new Object[MAX_ITEMS_NUMBER];
        values = (V[])new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        keys[usedSpace] = key;
        values[usedSpace] = value;
        usedSpace++;
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        V value = index == -1 ? null : values[index];
        return value;
    }

    @Override
    public int size() {
        return usedSpace;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < usedSpace; i++) {
            if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
