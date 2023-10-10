package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;
    private int size;

    public StorageImpl() {
        this.arrayOfKeys = (K[]) new Object[MAX_SIZE];
        this.arrayOfValues = (V[]) new Object[MAX_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == null && arrayOfKeys[i] == null
                    || key != null && key.equals(arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                return;
            }
        }
        if (size < MAX_SIZE) {
            arrayOfKeys[size] = key;
            arrayOfValues[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == null && arrayOfKeys[i] == null
                    || key != null && key.equals(arrayOfKeys[i])) {
                return (V) arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
