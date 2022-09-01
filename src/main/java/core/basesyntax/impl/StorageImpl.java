package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private int size;
    private K[] keyStorage;
    private V[] valueStorage;

    public StorageImpl() {
        keyStorage = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
        valueStorage = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        int index = size;
        for (int i = 0; i <= size; i++) {
            if (key == null && keyStorage[i] == null) {
                index = i;
                break;
            }
            if (key != null && key.equals(keyStorage[i])) {
                index = i;
            }
        }
        keyStorage[index] = key;
        valueStorage[index] = value;

        if (index == size) {
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = 0;
        for (int i = 0; i <= size; i++) {
            if (key == null && keyStorage[i] == null) {
                index = i;
                break;
            }
            if (key != null && key.equals(keyStorage[i])) {
                index = i;
            }
        }
        return valueStorage[index];
    }

    @Override
    public int size() {
        if (keyStorage[0] == null) {
            return size;
        }

        return size;
    }
}
