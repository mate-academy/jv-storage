package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private Object[] keys = new Object[MAX_SIZE];
    private Object[] values = new Object[MAX_SIZE];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        if (count < MAX_SIZE) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            throw new RuntimeException("Storage is already full");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null ? keys[i] == null : key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }
}
