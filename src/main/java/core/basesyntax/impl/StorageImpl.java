package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final K[] keys = (K[]) new Object[10];
    private final V[] values = (V[]) new Object[10];
    private int currentSize = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] != null) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                    return;
                }
            } else {
                if (key == null) {
                    values[i] = value;
                    return;
                }
            }
        }
        keys[currentSize] = key;
        values[currentSize] = value;
        currentSize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
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
