package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] boxKey = (K[]) new Object[MAX_SIZE];
    private V[] boxValue = (V[]) new Object[MAX_SIZE];
    private int size;

    @Override
    public void put(K key, V value) {
        if (size == MAX_SIZE) {
            throw new RuntimeException("Size is long");
        }
        for (int i = 0; i < size; i++) {
            if (boxKey[i] == key || key != null && key.equals(boxKey[i])) {
                boxValue[i] = value;
                return;
            }
        }
        boxKey[size] = key;
        boxValue[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (boxKey[i] == key || key != null && key.equals(boxKey[i])) {
                return boxValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
