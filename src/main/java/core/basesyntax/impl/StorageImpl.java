package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys;
    private V[] values;
    private int siize;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        values = (V[]) new Object[MAX_ITEMS_NUMBER];
        siize = 0;
    }

    private int findIndexByKey(K key) {
        for (int i = 0; i < siize; i++) {
            if ((keys[i] == null && key == null)
                    || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexByKey(key);

        if (index != -1) {
            values[index] = value;
            return;
        }
        if (siize == MAX_ITEMS_NUMBER) {
            throw new RuntimeException("Storage is full");
        }
        keys[siize] = key;
        values[siize] = value;
        siize++;
    }

    @Override
    public V get(K key) {
        int index = findIndexByKey(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return siize;
    }
}
