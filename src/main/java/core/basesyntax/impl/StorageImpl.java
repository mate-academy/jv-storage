package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keysArrays = (K[]) new Object[10];
    private V[] valueArrays = (V[]) new Object[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keysArrays[i] == null)
                    ||
                    (key != null && key.equals(keysArrays[i]))) {
                valueArrays[i] = value;
                return;
            }
        }
        keysArrays[size] = key;
        valueArrays[size] = value;
        size++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keysArrays[i] == null)
                    ||
                    (key != null && key.equals(keysArrays[i]))) {
                return valueArrays[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
