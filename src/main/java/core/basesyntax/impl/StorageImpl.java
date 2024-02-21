package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int STOREGE_CAPACITY = 10;
    private static int NOT_FOUND = -1;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[STOREGE_CAPACITY];
        values = (V[]) new Object[STOREGE_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size == STOREGE_CAPACITY) {
            throw new RuntimeException("Storage overflow");
        }
        if (get(key) == null) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            int index = getIndex(key);
            keys[index] = key;
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index != NOT_FOUND) {
            return values[index];
        }
        return null;
    }

    private int getIndex(K key) {
        for (int i = 0; i < STOREGE_CAPACITY; i++) {
            if (keys[i] == key || (keys[i] != null
                    && keys[i].equals(key))) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int size() {
        return size;
    }
}
