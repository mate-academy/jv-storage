package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private static final int NOT_FOUND_INDEX = -1;

    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyIndex = getKeyIndex(key);
        if (keyIndex != NOT_FOUND_INDEX) {
            values[keyIndex] = value;
            return;
        }

        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new StorageIsFullException("Storage is full! Maximum size is: " + MAX_SIZE);
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        if (index == NOT_FOUND_INDEX) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K keyToCompare) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == keyToCompare) || (keys[i] != null && keys[i].equals(keyToCompare))) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
