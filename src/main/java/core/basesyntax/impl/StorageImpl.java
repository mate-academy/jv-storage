package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;

    private K[] keys;
    private V[] values;
    private int currentSize;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAXIMUM_CAPACITY];
        this.values = (V[]) new Object[MAXIMUM_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        try {
            boolean isFound = false;
            for (int i = 0; i < currentSize; i++) {
                if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                    values[i] = value;
                    isFound = true;
                }
            }
            if (!isFound) {
                keys[currentSize] = key;
                values[currentSize] = value;
                currentSize++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Can`t put the pair. Storage is full!", e);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
