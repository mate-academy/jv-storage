package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY = 10;
    private int currentPosition;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
        currentPosition = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentPosition; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                values[i] = value;
                return;
            }
        }
        keys[currentPosition] = key;
        values[currentPosition] = value;
        currentPosition++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentPosition; i++) {
            if (key != null && key.equals(keys[i]) || key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentPosition;
    }
}
