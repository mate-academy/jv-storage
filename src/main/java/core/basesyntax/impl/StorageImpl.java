package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private int size;

    private K[] keysStorage;
    private V[] valuesStorage;

    public StorageImpl() {
        keysStorage = (K[]) new Object[STORAGE_SIZE];
        valuesStorage = (V[]) new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compare(keysStorage[i], key)) {
                valuesStorage[i] = value;
                return;
            }
        }
        keysStorage[size] = key;
        valuesStorage[size] = value;
        size++;
    }

    private boolean compare(K keyOne, K keyTwo) {
        return keyOne == keyTwo
                || keyOne != null && keyOne.equals(keyTwo);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysStorage.length; i++) {
            if ((key == null && keysStorage[i] == null)
                    || (key != null && key.equals(keysStorage[i]))) {
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
