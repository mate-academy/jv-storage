package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_SIZE = 10;
    private int currentSize;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[INITIAL_SIZE];
        this.values = (V[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void put(K key, V value) {
        boolean repeatKey = false;
        for (int i = 0; i < currentSize; i++) {
            if ((key == null && keys[i] == null) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                repeatKey = true;
                break;
            }
        }
        if (!repeatKey) {
            keys[currentSize] = key;
            values[currentSize] = value;
            currentSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((key == null && keys[i] == key) || (key != null && key.equals(keys[i]))) {
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
