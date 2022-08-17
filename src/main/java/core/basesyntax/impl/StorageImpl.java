package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys = (K[]) new Object[MAX_SIZE];
    private V[] values = (V[]) new Object[MAX_SIZE];

    private int elementCounter = 0;

    @Override
    public void put(K key, V value) {
        if (elementCounter < MAX_SIZE) {
            for (int i = 0; i < elementCounter; i++) {
                if (keys[i] == key || key != null && key.equals(keys[i])) {
                    values[i] = value;
                    return;
                }
            }
            keys[elementCounter] = key;
            values[elementCounter++] = value;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < elementCounter; i++) {
            if (keys[i] == key || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementCounter;
    }
}
