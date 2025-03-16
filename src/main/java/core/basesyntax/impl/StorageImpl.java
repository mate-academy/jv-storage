package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_CAP = 10;
    private int counter;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        counter = 0;
        keys = (K[]) new Object[MAX_STORAGE_CAP];
        values = (V[]) new Object[MAX_STORAGE_CAP];
    }

    @Override
    public void put(K key, V value) {
        if (counter == MAX_STORAGE_CAP) {
            throw new RuntimeException("The storage is full, you cannot add more elements!");
        }
        if (counter > 0) {
            int index = locateIndexIfKeyExist(key);
            if (index != -1) {
                values[index] = value;
                return;
            }
        }
        keys[counter] = key;
        values[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        int index = locateIndexIfKeyExist(key);
        return (index != -1) ? values[index] : null;
    }

    @Override
    public int size() {
        return counter;
    }

    private int locateIndexIfKeyExist(K key) {
        int result = -1;
        for (int i = 0; i < counter; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                result = i;
            }
        }
        return result;
    }
}
