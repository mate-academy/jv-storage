package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int currentSize;

    public StorageImpl() {

        this.keys = (K[]) new Object[INITIAL_MAX_SIZE];
        this.values = (V[]) new Object[INITIAL_MAX_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        if (currentSize == 0) {
            keys[0] = key;
            values[0] = value;
            currentSize++;
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            if ((key != null && key.equals(keys[i])) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
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
