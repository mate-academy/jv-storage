package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXIMAL_SIZE = 10;
    private K[] arrayOfKeys;
    private V[] arrayOfValues;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        arrayOfValues = (V[]) new Object[MAXIMAL_SIZE];
        arrayOfKeys = (K[]) new Object[MAXIMAL_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((arrayOfKeys[i] != null && arrayOfKeys[i].equals(key))
                    || (arrayOfKeys[i] == null && key == null)) {
                arrayOfValues[i] = value;
                return;
            }
        }
        if (size < MAXIMAL_SIZE) {
            arrayOfKeys[size] = key;
            arrayOfValues[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Provided size is to big, the maximum size is 10");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((arrayOfKeys[i] != null && arrayOfKeys[i].equals(key))
                    || (arrayOfKeys[i] == null && key == null)) {
                return arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
