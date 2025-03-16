package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_SIZE];
        values = (V[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int replaceIndex = checkKeyIndex(key);
        if (replaceIndex != -1) {
            values[replaceIndex] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int searchedIndex = checkKeyIndex(key);
        return (searchedIndex == -1) ? null : values[searchedIndex];
    }

    private int checkKeyIndex(K wantedKey) {
        for (int i = 0; i < this.size; i++) {
            if (keys[i] == wantedKey
                    || keys[i] != null && wantedKey != null && keys[i].equals(wantedKey)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
