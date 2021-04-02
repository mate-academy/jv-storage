package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] storageArray;

    public StorageImpl() {
        storageArray = new Object[ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        storageArray[getIndex(key)] = value;
    }

    public int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % ARRAY_SIZE);
    }

    @Override
    public V get(K key) {
        return (V) storageArray[getIndex(key)];
    }

    @Override
    public int size() {
        int count = 0;
        for (Object element : storageArray) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }
}
