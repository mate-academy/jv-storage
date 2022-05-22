package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || (keyArray[i] != null && keyArray[i].equals(key))) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[size] = key;
        valueArray[size] = value;
        size++;

    }

    @Override
    public V get(K key) {

        for (int i = 0; i < size; i++) {
            if (key == keyArray[i] || (keyArray[i] != null && keyArray[i].equals(key))) {
                return (V) valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
