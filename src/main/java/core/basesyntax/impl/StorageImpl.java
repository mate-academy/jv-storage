package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_MAX_SIZE = 10;

    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[ARRAY_MAX_SIZE];
        values = (V[]) new Object[ARRAY_MAX_SIZE];
    }

    private int findIndexKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == null ? key == null : keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexKey(key);
        try {
            if (index != -1) {
                values[index] = value;
            } else if (size < ARRAY_MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Vault out of size" + e);
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexKey(key);
        return index == -1 ? null : (V) values[index];
    }

    @Override
    public int size() {
        return size;
    }
}
