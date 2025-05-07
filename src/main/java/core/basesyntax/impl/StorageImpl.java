package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private K[] keys = (K[]) new Object[ARRAY_SIZE];
    private V[] values = (V[]) new Object[ARRAY_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(i, key)) {
                values[i] = value;
                return;
            }
        }
        if (size < ARRAY_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException(
                    String.format("Can't store more than %d elements", ARRAY_SIZE));
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysAreEqual(i, key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean keysAreEqual(int i, K key) {
        return (keys[i] != null && keys[i].equals(key)) || (keys[i] == null && key == null);
    }
}
