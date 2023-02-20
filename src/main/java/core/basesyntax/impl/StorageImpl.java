package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private K[] keysStorage;
    private V[] valuesStorage;

    private int size = 0;

    public StorageImpl() {
        keysStorage = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        valuesStorage = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((keysStorage[i] != null) && keysStorage[i].equals(key) || (keysStorage[i] == key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[size] = key;
        valuesStorage[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysStorage[i] == key || (keysStorage[i] != null) && keysStorage[i].equals(key)) {
                return valuesStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
