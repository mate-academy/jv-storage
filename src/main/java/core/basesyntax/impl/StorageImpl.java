package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int keyNumber = getNumberIfExists(key);
        if (keyNumber != -1) {
            keys[keyNumber] = key;
            values[keyNumber] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int keyNumber = getNumberIfExists(key);
        return keyNumber != -1 ? values[keyNumber] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getNumberIfExists(K key) {
        for (int i = 0; i < size; i++) {
            if ((keys[i] == key) || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
