package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int STORAGE_CAPACITY = 10;
    private K[] keyArray = (K[]) new Object[STORAGE_CAPACITY];
    private V[] valArray = (V[]) new Object[STORAGE_CAPACITY];
    private int sizeArray = 0;

    @Override
    public void put(K key, V value) {

        for (int i = 0;i < sizeArray;i++) {
            if (keyEquals(i,key)) {
                valArray[i] = value;
                return;
            }
        }
        keyArray[sizeArray] = key;
        valArray[sizeArray] = value;
        sizeArray++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeArray;i++) {
            if (keyEquals(i,key)) {
                return valArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeArray;
    }

    private boolean keyEquals(int index,K key) {

        return key == keyArray[index] || key != null && key.equals(keyArray[index]);
    }
}
