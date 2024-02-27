package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private K[] keyArray = (K[]) new Object[STORAGE_SIZE];
    private V[] valueArray = (V[]) new Object[STORAGE_SIZE];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (isKeyAtStorage(key, i)) {
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
        for (int i = 0; i < keyArray.length; i++) {
            if (isKeyAtStorage(key, i)) {
                return valueArray[i];
            }
        }
        return null;
    }

    private boolean isKeyAtStorage(K key, int i) {
        if ((keyArray[i] == null && key == null)
                || (keyArray[i] != null && keyArray[i].equals(key))) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
