package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        keys = (K[])new Object[MAX_SIZE];
        values = (V[])new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (keyExists(key)) {
            values[findKeyIndex(key)] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        return keyExists(key) ? values[findKeyIndex(key)] : null;
    }

    @Override
    public int size() {
        return size;
    }

    public int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean keyExists(K key) {
        int keyIndex = findKeyIndex(key);
        return keyIndex >= 0;
    }
}
