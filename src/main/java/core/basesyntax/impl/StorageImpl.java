package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int freeCellIndex = 0;

    public StorageImpl() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        values = (V[]) new Object[INITIAL_CAPACITY];
        freeCellIndex = 0;
    }

    @Override
    public void put(K key, V value) {
        int indexOfKeyExisted = searchByKey(key);
        if (indexOfKeyExisted >= 0) {
            values[indexOfKeyExisted] = value;
        } else {
            keys[freeCellIndex] = key;
            values[freeCellIndex] = value;
            freeCellIndex++;
        }
    }

    @Override
    public V get(K key) {
        int searchResult = searchByKey(key);
        return searchResult >= 0 ? values[searchResult] : null;
    }

    @Override
    public int size() {
        return freeCellIndex;
    }

    private int searchByKey(K key) {
        for (int i = 0; i < freeCellIndex; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
