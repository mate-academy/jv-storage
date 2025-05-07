package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        this.values = (V[]) new Object[MAXIMUM_NUMBER_OF_ELEMENTS];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else if (size < MAXIMUM_NUMBER_OF_ELEMENTS) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage is full, can not add more elements");
        }
    }

    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return (index >= 0) ? values[index] : null;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keysMatch(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean keysMatch(K key, K storedKey) {
        return (key == null && storedKey == null) || (storedKey != null && storedKey.equals(key));
    }

    @Override
    public int size() {
        return size;
    }
}
