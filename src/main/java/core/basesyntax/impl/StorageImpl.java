package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 5;
    private int size;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        valueArray = (V[])new Object[ARRAY_LENGTH];
        keyArray = (K[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (isNull(key, i)) {
                valueArray[i] = value;
                size++;
                return;
            } else if (isAlreadyExistKey(key, i)) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < ARRAY_LENGTH) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keyArray[i] == null) || (key != null && key.equals(keyArray[i]))) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isNull(K key, int index) {
        return key == null && keyArray[index] == null && valueArray[index] == null;
    }

    private boolean isAlreadyExistKey(K key, int index) {
        return (key == null && keyArray[index] == null && valueArray[index] != null)
                || (key != null && key.equals(keyArray[index]));
    }
}
