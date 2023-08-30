package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(keys, key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Size is over");
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(keys, key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int findKeyIndex(K[] keysArray, K keyToFind) {
        for (int i = 0; i < size; i++) {
            if (keysArray[i] == null ? keyToFind == null : keysArray[i].equals(keyToFind)) {
                return i;
            }
        }
        return -1;
    }
}
