package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int size;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ITEMS_NUMBER];
        valueArray = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key || keyArray[i] != null && keyArray[i].equals(key)) {
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
            if (keyArray[i] == key || keyArray[i] != null && keyArray[i].equals(key)) {
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
